// Blocker.java
// Subclass of GameElement customized for the Blocker
package com.example.tipper.activities

class Blocker     // constructor
(view: CannonView?, color: Int, // the miss penalty for this Blocker
 private val missPenalty: Int, x: Int,
 y: Int, width: Int, length: Int, velocityY: Float) : GameElement(view, color, CannonView.Companion.BLOCKER_SOUND_ID, x, y, width, length,
        velocityY) {
 // returns the miss penalty for this Blocker
 fun getMissPenalty(): Int {
  return missPenalty
 }
}