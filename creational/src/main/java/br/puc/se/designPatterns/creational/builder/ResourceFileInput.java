package br.puc.se.designPatterns.creational.builder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class ResourceFileInput implements Input<String> {

	private StringBuilder stringBuilder;
	
	public ResourceFileInput(String pathToResource) {
		stringBuilder =  new StringBuilder();
		try {
			ClassLoader classLoader = ClassLoader.getSystemClassLoader();
			File file = new File(classLoader.getResource(pathToResource).getFile());
			String content = new String(Files.readAllBytes(file.toPath()));
			stringBuilder.append(content);
		} catch (IOException e) {
			stringBuilder.append("Could not load the file");
		}
	}

        @Override
	public String getContent() {
		return this.stringBuilder.toString();
	}

}
