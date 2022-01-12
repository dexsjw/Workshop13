package nus.iss.workshop13;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.DefaultApplicationArguments;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;	

import static nus.iss.workshop13.util.IOUtil.*;

@SpringBootApplication
public class Workshop13Application {

	private static final Logger logger = LoggerFactory.getLogger(Workshop13Application.class);

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(Workshop13Application.class);
		DefaultApplicationArguments appArgs = new DefaultApplicationArguments(args);

		List<String> optVal = appArgs.getOptionValues("dataDir");
		
		if (appArgs.containsOption("dataDir")) {
			if (!checkDir((String)optVal.get(0)))
				createDir((String)optVal.get(0));

		} else {

			logger.warn("Error! Please use --dataDir as option to set data directory!");
			System.exit(1);

		}

		app.run(args);
	}
	
}
