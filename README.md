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

### Lambda Interface dengan Parameter

```java

@FunctionalInterface
public interface SimpleActionParam {
    String action(String name);
}
```

### Lambda dengan Parameter

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

### Lambda tanpa Block

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

---

## <span name="java-util-function">Java Util Function</span>

### Package java.util.function

- Saat Java 8 rilis dengan fitur Lambda-nya, Java juga menyediakan sebuah package baru bernama `java.util.function`
- Package ini berisikan banyak sekali fitur Functional Interface yang bisa kita gunakan untuk kebutuhan membuat Lambda
- Dengan menggunakan Interface-Interface yang ada di package ini, kita mungkin tidak perlu lagi membuat Functional
  Interface secara manual

### Interface Consumer

```java
public class ConsumerApp {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        consumer.accept("Hello World!"); // Hello World!
    }
}
```

### Interface Function

```java
public class FunctionApp {
    public static void main(String[] args) {
        Function<String, Integer> function = value -> value.length();
        System.out.println(function.apply("Hello World!")); // 12
    }
}
```

### Interface Predicate

```java
public class PredicateApp {
    public static void main(String[] args) {
        Predicate<String> predicate = param -> param.isBlank();
        System.out.println(predicate.test("Hello World!")); // false
    }
}
```

### Interface Supplier

```java
public class SupplierApp {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Hello World!";
        System.out.println(supplier.get()); // Hello World!
    }
}
```

![Interface-Interface lainnya](https://user-images.githubusercontent.com/69947442/129477203-f6f23f38-1315-4eb5-b046-53de5f084bf2.png)