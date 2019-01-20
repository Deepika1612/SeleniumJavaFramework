package Config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import Test.FacebookLoginPageTest;

public class PropertiesFile {

	public static void main(String[] args) throws IOException {

		getProperties();

	}

	public static void getProperties() throws IOException {

		Properties prop = new Properties();

		InputStream input = new FileInputStream(
				"C:\\Users\\hp\\Desktop\\Deepika\\SeleniumProject\\SeleniumJavaFramework\\src\\test\\java\\Config\\config.properties");
		prop.load(input);

		FacebookLoginPageTest.browserName = prop.getProperty("browser");

	}

}
