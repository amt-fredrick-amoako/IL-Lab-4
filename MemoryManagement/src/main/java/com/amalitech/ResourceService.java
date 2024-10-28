package com.amalitech;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

// A sample class simulating a service with listeners
public class ResourceService {
    private final List<WeakReference<UpdateListener>> listeners = new ArrayList<>();
    private String filePath;

    public ResourceService(String filePath) {
        this.filePath = filePath;
    }

    // Method to add listeners with a weak reference to avoid memory leaks
    public void addListener(UpdateListener listener) {
        listeners.add(new WeakReference<>(listener));
    }

    // Method to remove listeners
    public void removeListener(UpdateListener listener) {
        listeners.removeIf(ref -> ref.get() == listener);
    }

    // Method to notify all listeners with weak references, cleaning up null references
    private void notifyListeners(String message) {
        for (WeakReference<UpdateListener> ref : new ArrayList<>(listeners)) {
            UpdateListener listener = ref.get();
            if (listener != null) {
                listener.onUpdate(message);
            } else {
                listeners.remove(ref); // Remove null references
            }
        }
    }

    // Method to read and process file, simulating resource management
    public void processFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                notifyListeners("New line read: " + line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Initialize the service with the path to a file
        ResourceService service = new ResourceService("C:\\Users\\FredrickAmoako\\source\\repos\\IL-Lab-4\\MemoryManagement\\src\\main\\java\\com\\amalitech\\sample.txt");

        // Add listeners to the service
        UpdateListener listener1 = message -> System.out.println("Listener1 received: " + message);
        UpdateListener listener2 = message -> System.out.println("Listener2 received: " + message);
        service.addListener(listener1);
        service.addListener(listener2);

        // Simulate file processing and notifications
        service.processFile();

        // Remove listeners when no longer needed to prevent memory leaks
        service.removeListener(listener1);
        service.removeListener(listener2);
    }
}
