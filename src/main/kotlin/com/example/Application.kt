package com.example

import io.micronaut.runtime.Micronaut.run
import io.micronaut.scheduling.annotation.Scheduled
import io.micronaut.tracing.annotation.NewSpan
import io.opentelemetry.api.trace.Span
import jakarta.inject.Singleton


@Singleton
open class DoSomething() {
	@Scheduled(initialDelay = "0s", fixedRate = "5s")
	@NewSpan
	open fun banana() {
		val spanContext = Span.current().spanContext
		System.out.printf(
			"[!dt dt.trace_id=%s,dt.span_id=%s,isValid=%s] - %s%n",
			spanContext.traceId,
			spanContext.spanId,
			spanContext.isValid,
			"hello"
		)
	}
}


fun main(args: Array<String>) {
	run(*args)
}

