package mpdev.aoc2023.utils

import java.lang.StringBuilder

open class TreeNode<T>(var nodeData: T, var parent: TreeNode<T>? = null, var children: MutableList<TreeNode<T>> = mutableListOf()) {

    fun addChild(node: T) {
        children.add(TreeNode(node, this))
    }

    fun walk(f: (TreeNode<T>) -> Unit) {
        f(this)
        children.forEach { it.walk(f) }
    }

    fun walk(f: (TreeNode<T>) -> Unit, condition: (TreeNode<T>) -> Boolean) {
        if (condition(this))
            f(this)
        children.forEach { it.walk(f, condition) }
    }

    fun find(condition: (TreeNode<T>) -> Boolean): TreeNode<T>? {
        if (condition(this))
            return this
        else
            children.forEach {
                val check = condition(it)
                if (check)
                    return it
            }
        return null
    }

    fun findRoot(): TreeNode<T> {
        return if (parent == null)
            this
        else
            this.parent!!.findRoot()
    }

    fun getPathFromRoot(getValue: (TreeNode<T>) -> String, separator: String = "."): String {
        val path = getPathFromRoot(mutableListOf(), getValue)
        if (path.last() == separator)
            path.removeAt(path.lastIndex)
        return separator + path.reversed().joinToString(separator)
    }

    private fun getPathFromRoot(path: MutableList<String>, getValue: (TreeNode<T>) -> String): MutableList<String> {
        path.add(getValue(this))
        if (parent == null)
            return path
        else
            return parent!!.getPathFromRoot(path, getValue)
    }

    fun sumOf(item: (TreeNode<T>) -> Int): Int {
        return item(this) + children.sumOf(item)
    }

    fun sumOf(item: (TreeNode<T>) -> Int, condition: (TreeNode<T>) -> Boolean): Int {
        var sum = if (condition(this)) item(this) else 0
        children.forEach { sum += it.sumOf(item, condition) }
        return sum
    }

    fun <K,V>toMap(getKey: (TreeNode<T>) -> K, getValue: (TreeNode<T>) -> V): Map<K,V> {
        val resMap = mutableMapOf<K,V>()
        resMap[getKey(this)] = getValue(this)
        children.forEach { resMap.putAll(it.toMap(getKey, getValue)) }
        return resMap
    }

    fun <K,V>toMap(getKey: (TreeNode<T>) -> K, getValue: (TreeNode<T>) -> V, condition: (TreeNode<T>) -> Boolean): Map<K,V> {
        val resMap = mutableMapOf<K,V>()
        if (condition(this))
            resMap[getKey(this)] = getValue(this)
        children.forEach { resMap.putAll(it.toMap(getKey, getValue, condition)) }
        return resMap
    }

    fun <V>toList(getValue: (TreeNode<T>) -> V): List<V> {
        val resList = mutableListOf<V>()
        resList.add(getValue(this))
        children.forEach { resList.addAll(it.toList(getValue)) }
        return resList
    }

    fun <V>toList(getValue: (TreeNode<T>) -> V, condition: (TreeNode<T>) -> Boolean): List<V> {
        val resList = mutableListOf<V>()
        if (condition(this))
            resList.add(getValue(this))
        children.forEach { resList.addAll(it.toList(getValue, condition)) }
        return resList
    }

    override fun toString() = toString("")

    fun toString(padding: String): String {
        var out = "$padding${nodeData.toString()}"
        out += StringBuilder().also {
            children.forEach { entry -> it.append(entry.toString("$padding  ")) }
        }
        return out
    }
}