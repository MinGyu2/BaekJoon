package com.baekjoon.problem

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList

class KeyLogger(private val case:String){
    private var cursorLocate=0
//    private val stringBuilder:StringBuilder by lazy {
//        StringBuilder("")
//    }
    private val linkedList:LinkedList<Char> by lazy{
        LinkedList<Char>()
    }
    private fun backspace(){ // -
        if(cursorLocate == 0) return
        this.cursorMoveLeft()
        //TODO("삭제 추가")
//        if(stringBuilder.isNotEmpty()) stringBuilder.deleteCharAt(cursorLocate)
        if(linkedList.isNotEmpty()) linkedList.removeAt(cursorLocate)
    }
    private fun cursorMoveRight(){ // >
        cursorLocate++
//        cursorLocate = if(cursorLocate > stringBuilder.length) stringBuilder.length else cursorLocate
        cursorLocate = if(cursorLocate > linkedList.size) linkedList.size else cursorLocate
    }
    private fun cursorMoveLeft(){ // <
        cursorLocate--
        cursorLocate = if(cursorLocate < 0) 0 else cursorLocate
    }
    private fun writeString(c:Char){
        //TODO("적기")
//        stringBuilder.insert(cursorLocate,c)
        linkedList.add(cursorLocate,c)
        cursorMoveRight()
    }
    fun getKey():LinkedList<Char>{
        for(k in case){
            when(k){
                '>' -> cursorMoveRight()
                '<' -> cursorMoveLeft()
                '-' -> backspace()
                else -> writeString(k)
            }
        }
//        return stringBuilder
        return linkedList
    }
}

fun main(){
    val stringInput= BufferedReader(InputStreamReader(System.`in`))
    val stringBuilder= StringBuilder()
    for(k in 1..readLine()!!.toInt()) {
        val test = KeyLogger(stringInput.readLine())
        for(k in test.getKey())
            stringBuilder.append(k)
//            stringBuilder.append(test.getKey())
        stringBuilder.append('\n')
    }
    println(stringBuilder)
}