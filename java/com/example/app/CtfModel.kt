package com.example.app

class CtfModel(private var name: String) {

    override fun toString(): String {
        return "CtfModel{name='$name'}"
    }

    fun getName(): String {
        return name
    }

    fun setName(name: String) {
        this.name = name
    }
}
