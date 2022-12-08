package com.example.benchmarks.jibber;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.micrometer.core.annotation.Timed;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Controller which serves as an entry-point for requests for jibber nonsense verse.
 *
 */
@RestController
@RequestMapping("/jibber")
@Timed
public class JibberController {
    private static final Logger log = LoggerFactory.getLogger(JibberController.class);

    @Autowired
    Jabberwocky j;

    @RequestMapping
    ResponseEntity<String> jibber() {
        log.info("Got a request /");
        return ResponseEntity.ok(j.generate());
    }

    @RequestMapping(value = "/{number}")
    ResponseEntity<String> jibberN(@PathVariable int number) {
        log.info("Got a request /number");
        return ResponseEntity.ok(j.generate(number));
    }
}
