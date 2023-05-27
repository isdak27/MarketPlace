package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import model.Client;
import model.Invoice;
import model.ProductStock;

public class JsonReaderWriter {

	private static final String CLIENTS_JSON_FILE = "data/clients.json";
	private static final String PRODUCTS_JSON_FILE = "data/products.json";
	private static final String INVOICES_JSON_FILE = "data/invoices.json";

	private static Gson gson = new GsonBuilder().setPrettyPrinting().create();

	public static List<Client> readClientsFromJson() {
		try {
			File file = new File(CLIENTS_JSON_FILE);
			if (!file.exists()) {
				return null;
			}

			FileReader reader = new FileReader(file);
			Type listType = new TypeToken<List<Client>>() {
			}.getType();
			List<Client> clients = gson.fromJson(reader, listType);
			reader.close();
			return clients;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean writeClientsToJson(List<Client> clients) {
		try {
			FileWriter writer = new FileWriter(CLIENTS_JSON_FILE);
			gson.toJson(clients, writer);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<ProductStock> readProductsFromJson() {
		try {
			File file = new File(PRODUCTS_JSON_FILE);
			if (!file.exists()) {
				return null;
			}

			FileReader reader = new FileReader(file);
			Type listType = new TypeToken<List<ProductStock>>() {
			}.getType();
			List<ProductStock> products = gson.fromJson(reader, listType);
			reader.close();
			return products;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean writeProductsToJson(List<ProductStock> products) {
		try {
			FileWriter writer = new FileWriter(PRODUCTS_JSON_FILE);
			gson.toJson(products, writer);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static List<Invoice> readInvoicesFromJson() {
		try {
			File file = new File(INVOICES_JSON_FILE);
			if (!file.exists()) {
				return null;
			}

			FileReader reader = new FileReader(file);
			Type listType = new TypeToken<List<Invoice>>() {
			}.getType();
			List<Invoice> invoices = gson.fromJson(reader, listType);
			reader.close();
			return invoices;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static boolean writeInvoicesToJson(List<Invoice> invoices) {
		try {
			FileWriter writer = new FileWriter(INVOICES_JSON_FILE);
			gson.toJson(invoices, writer);
			writer.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

}
