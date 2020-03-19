package br.com.cryptonews.mapper

import br.com.cryptonews.entities.Source
import br.com.cryptonews.model.SourceObject

fun Source.mapToObject() = SourceObject(
    id = this.id,
    name = this.name
)