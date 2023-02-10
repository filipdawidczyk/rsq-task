package com.example.rsqtask

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import java.time.Clock

@SpringBootApplication
@EnableJpaRepositories
class RsqTaskApplication {
    @Bean
    fun defaultClock(): Clock = Clock.systemDefaultZone()
}

fun main(args: Array<String>) {
    runApplication<RsqTaskApplication>(*args)
}
