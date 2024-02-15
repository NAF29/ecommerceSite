package readConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class ReadConfig {

	Properties properties;
	String path = "/Users/nafis/eclipse/DemoSites/src/test/java/Config.properties";

	public ReadConfig() throws IOException {

		properties = new Properties();

		try {
			FileInputStream fileInputStream = new FileInputStream(path);
			properties.load(fileInputStream);

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
			
	}

	public String getURl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else {
			throw new RuntimeException("url not specified");
		}

	}

	public String getEmail() {
		String email = properties.getProperty("email");
		return email;

	}

	public String getPassword() {
		String password = properties.getProperty("invalidPass");
		return password;
	}
}
