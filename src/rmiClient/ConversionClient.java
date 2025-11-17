package rmiClient;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import rmiService.IConversion;

public class ConversionClient {

    public static void main(String[] args) {
        try {
            // Connect to registry
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            // Lookup service
            IConversion stub = (IConversion) registry.lookup("CONVERSION_SERVICE");
            System.out.println("Connected to RMI service.");

            // Invoke remote method
            double result = stub.convertirMontant(500);
            System.out.println("500€ = " + result + " Dinars");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
