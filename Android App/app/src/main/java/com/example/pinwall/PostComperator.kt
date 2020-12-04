package com.example.pinwall

class PostComperator : Comparator<Post?> {
    override fun compare(p0: Post?, p1: Post?): Int {
        var result = 0
        if (p0 != null && p1 != null) {
            result = -p0.timestamp.compareTo(p1.timestamp)
        }
        return result
    }
}