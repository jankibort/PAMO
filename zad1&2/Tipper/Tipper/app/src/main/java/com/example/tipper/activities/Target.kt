// Target.java
// Subclass of GameElement customized for the Target
package com.example.tipper.activities

class Target     // constructor
(view: CannonView?, color: Int, // the hit reward for this target
 private val hitReward: Int, x: Int, y: Int,
 width: Int, length: Int, velocityY: Float) : GameElement(view, color, CannonView.Companion.TARGET_SOUND_ID, x, y, width, length,
        velocityY) {
 // returns the hit reward for this Target
 fun getHitReward(): Int {
  return hitReward
 }
}