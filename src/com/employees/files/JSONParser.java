package com.employees.files;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javatest.AbstractEmployee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.employees.app.Employee;
import com.employees.app.Manager;

public class JSONParser {

	// Singleton
	private static JSONParser pJSONParser = new JSONParser();

	// Manager
	Manager manager;

	private JSONParser() {
		InputStream in;
		JSONObject json;

		try {
			in = getClass().getResourceAsStream("employees.json");
			json = new JSONObject(getStringFromInputStream(in))
					.getJSONObject("manager");
			manager = new Manager(json.getString("name"), json.getInt("salary"));
			extendTree(manager, json);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Get the full tree of employees
	 */
	public void extendTree(Manager manager, JSONObject json) {
		AbstractEmployee abstractEmployee;
		JSONObject json2;
		JSONArray jarr;

		try {
			jarr = json.getJSONArray("subemployees");
			for (int i = 0; i < jarr.length(); i++) {
				json2 = jarr.getJSONObject(i);
				if (JSONObject.getNames(json2).length == 3) {
					abstractEmployee = new Manager(json2.getString("name"),
							json2.getInt("salary"));
					extendTree((Manager) abstractEmployee, json2);
				} else {
					abstractEmployee = new Employee(json2.getString("name"),
							json2.getInt("salary"));
				}
				manager.addEmployee(abstractEmployee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// convert InputStream to String
	private String getStringFromInputStream(InputStream is) {
		BufferedReader br = null;
		StringBuilder sb = new StringBuilder();
		String line;

		try {
			br = new BufferedReader(new InputStreamReader(is));
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return sb.toString();
	}

	public static JSONParser getJSONParser() {
		return pJSONParser;
	}

	public Manager getManager() {
		return manager;
	}
}
