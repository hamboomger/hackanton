package com.hamboomger.crossweb.controller;

import com.hamboomger.crossweb.service.CrosswebScannerService;
import com.hamboomger.model.event.IEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

/**
 * @author ddorochov
 */
@RestController("/crossweb")
public class CrosswebRestController {

	private final CrosswebScannerService scannerService;

	@Autowired
	public CrosswebRestController(CrosswebScannerService scannerService) {
		this.scannerService = scannerService;
	}

	@GetMapping("/scan")
	public List<IEvent> scanEvents() throws IOException {
		return scannerService.scanEvents(false);
	}

}
