# [Java Lambda]()

Lambda expressions basically express instances of functional interfaces (An interface with single abstract method is
called functional interface. An example is java.lang.Runnable). lambda expressions implement the only abstract function
and therefore implement functional interfaces. [GeeksforGeeks](https://www.geeksforgeeks.org/lambda-expressions-java-8/)

[Official Documentation](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)

Sumber Tutorial:
[Youtube](https://www.youtube.com/watch?v=AtF2EHZ1fXo) |
[Slide](https://docs.google.com/presentation/d/154ri_lNOQB8lXMWQMxw2l2NXhIgCQSaCFtBtZ0VxGAw/edit#slide=id.p)

Sebelum Belajar Materi Ini:

- [Java Dasar](https://www.youtube.com/watch?v=jiUxHm9l1KY)
- [Java Object Oriented Programming](https://www.youtube.com/watch?v=f3ZhNnvtV-w)
- [Java Generic](https://www.youtube.com/watch?v=bvWRDAl30Gs)
- [Java Collection](https://www.youtube.com/watch?v=_JEMfq4k2O4)

## Daftar Isi

- [Pengenalan Lambda](#pengenalan-lambda)
- [Membuat Lambda](#membuat-lambda)
- [Java Util Function](#java-util-function)
- [Method Reference](#method-reference)
- [Lambda di Collection](#lambda-collection)
- [Lambda Sebagai Lazy Parameter](#lambda-lazy-parameter)
- [Lambda di Optional](#lambda-optional)

---

## <span name="pengenalan-lambda">Pengenalan Lambda</span>

### Apa itu lambda?

- Lambda berasal dari lambda calculus, yang mengacu pada Anonymous Function (fungsi tanpa nama)
- Tapi, di Java function/method tidak dapat berdiri sendiri
- Jadi kemungkinan pada prakteknya, lambda di Java dan di bahasa pemrograman lain akan berbeda

### Anonymous Class

- Di Java kita hanya mengenal Anonymous Class
- Lambda di Java sebenarnya adalah versi sederhana membuat sebuah Anonymous Class

### Syarat Lambda

- Berupa Interface
- Hanya memiliki 1 method abstract
- Ditambahkan annotation `@FunctionInterface` pada Interface nya
- Minimal menggunakan Java 8

Contoh:

```java

@FunctionalInterface
public interface SimpleAction {
    String action();
}
```

---

## <span name="membuat-lambda">Membuat Lambda</span>

- Di seksi sebelumnya kita sudah mencoba membuat lambda
- Sekarang kita akan bahas beberapa cara membuat lambda lainnya

## Lambda Interface dengan Parameter

```java

@FunctionalInterface
public interface SimpleActionParam {
    String action(String name);
}
```

## Lambda dengan Parameter

```java
public class SimpleActionParamApp {
    public static void main(String[] args) {
        SimpleActionParam simpleActionParam1 = (String name) -> {
            return "Hello, " + name;
        };
        SimpleActionParam simpleActionParam2 = (name) -> {
            return "Hello, " + name;
        };
    }
}
```

## Lambda tanpa Block

```java
public class SimpleActionParamApp {
    public static void main(String[] args) {
        SimpleActionParam simpleActionParam3 = (String name) -> "Hello, " + name;
        SimpleActionParam simpleActionParam4 = (name) -> "Hello, " + name;
        SimpleActionParam simpleActionParam5 = name -> "Hello, " + name;
        SimpleActionParam simpleActionParam6 = param -> "Hello, " + param;
    }
}
```