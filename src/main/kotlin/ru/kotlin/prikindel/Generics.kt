package ru.kotlin.prikindel

/*
class Box<T>(val value: T)

fun main() {
    val intBox = Box(10)
    val catBox = Box("Нюша")

    val a = intBox.value
    val c = catBox.value
    echo(catBox.value)
}

fun <T> echo(value: T) {
    print(value)
}*/

/*
open class Animal(val name: CharSequence)

class Cat<T: CharSequence>(name: T) : Animal(name), Vehicle {
    fun meow() {
        println("$name мяукает")
    }

    override fun run() {
        TODO("Not yet implemented")
    }
}

class Dog(name: String) : Animal(name) {
    fun bark() {
        println("$name лает")
    }
}

interface Vehicle {
    fun run()
}

//fun <T : Animal> printAnimalName(animal: T) {
//    println(animal.name)
//}

fun <T> printAnimalName(animal: T) where T : Animal, T : Vehicle {
    println(animal.name)
}

fun main() {
    val cat = Cat("Барсик")
    printAnimalName(cat)
}*/

/*
open class Animal
class Cat : Animal()
class Dog : Animal()

class Box<out T>(val value: T)
class Box2<in T> {
    fun put(value: T) {

    }
}

fun main() {
    val boxWithCat: Box<Cat> = Box(Cat())
    val box: Box2<Animal> = Box2()
    fillWithCat(box)
    printAnimal(boxWithCat)

    val listCat = listOf(Cat())
    val listAnimal: List<Animal> = listCat
}

fun printAnimal(box: Box<Animal>) {
    println(box.value)
}

fun fillWithCat(box: Box2<Cat>) {
    box.put(Cat())
}*/

/*
class Box<T>(val value: T)

val intBox = Box(10)
val stringBox = Box("as")

val boxes: List<Box<*>> = listOf(intBox, stringBox)

val box: Box<*> = Box(10)*/

class Box(val value: Int)

inline fun <reified T> Any.isType(): Boolean {
    return this is T
}

fun foo(value: Any) {
    val box = value.cast<Box>()
    box?.value
    if (value.isType<Box>()) {

    } else {

    }
}

inline fun <reified T> Any.cast(): T? {
    return this as? T
}

inline fun <reified T> List<*>.filterIsInstance(crossinline body: T.() -> T): List<T> {
    return this.mapNotNull { it as? T }
        .map { it.body() }
//    return this.filterIsInstance(T::class.java)
}

inline fun fod(noinline body: () -> Unit) {
    d(body)
}
fun d(body: () -> Unit) {
    body()

    val ten = 10

    ten times body
    ten.times(body)
}

infix fun Int.times(body: () -> Unit) {
    repeat(this) { body() }
}