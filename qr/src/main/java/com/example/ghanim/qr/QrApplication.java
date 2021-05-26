package com.example.ghanim.qr;

import nu.pattern.OpenCV;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QrApplication {

	public static void main(String[] args) {
		SpringApplication.run(QrApplication.class, args);
		OpenCV.loadShared();
	}
}
