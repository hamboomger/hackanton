package com.hamboomger.model.event

import com.hamboomger.model.common.Language
import java.time.LocalDateTime
import java.util.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

/**
 * @author ddorochov
 */
@MappedSuperclass
open class Event(
    val type: EventType,
    val topics : List<String>,
    val priceType: PriceType,
    val dateAndTime: LocalDateTime,
    val pageUrl: String,
    val address: EventAddress,
    val agenda: EventAgenda,
    val description: String,
    val language: Language
) {
    @Id
    @GeneratedValue
    private val id = 0L
}