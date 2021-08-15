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

---

## <span name="method-reference">Method Reference</span>

- Kadang saat membuat Lambda, isi Lambda hanya mengakses Method lain atau mengakses Method yang ada di parameter Lambda
  nya
- Kita bisa mempersingkat pembuatan Lambda tersebut dengan Method Reference

### Static Method

```java
public class StringUtilStatic {
    public static boolean isLowerCase(String param) {
        for (char c : param.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }
}
```

### Method Reference Static

```java
public class StringUtilStaticApp {
    public static void main(String[] args) {
        Predicate<String> predicate = StringUtil::isLowerCase;
        System.out.println(predicate.test("hello")); // true
    }
}
```

### Method Reference non-Static

```java
public class StringUtilNonStaticApp {
    public boolean isLowerCase(String param) {
        for (char c : param.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }

    public void nonStaticPredicate() {
        Predicate<String> nonStaticPredicate = this::isLowerCase;
        System.out.println(nonStaticPredicate.test("hello")); // true
    }
}
```

### Method Reference Object

```java
public class StringUtilObjectApp {
    public boolean isLowerCase(String param) {
        for (char c : param.toCharArray()) {
            if (!Character.isLowerCase(c)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        StringUtilApp app = new StringUtilApp();
        Predicate<String> nonStaticPredicate = app::isLowerCase;
        System.out.println(nonStaticPredicate.test("hello")); // true
    }
}
```

### Method Reference Parameter

```java
public class StringUtilParameterApp {
    public static void main(String[] args) {
        Function<String, String> functionUpperCase = String::toUpperCase;
        System.out.println(functionUpperCase.apply("hello kecil")); // HELLO KECIL
    }
}
```

---

## <span name="lambda-collection">Lambda di Collection</span>

- Saat fitur Lambda rilis di Java 8, ada banyak sekali Default Method yang ditambahkan ke Java Collection
- Beberapa ada Default Method yang banyak memanfaatkan fitur Lambda
- Di materi ini akan bahas beberapa Method yang memanfaatkan Lambda

### Iterable.forEach

```java
public class ForEachApp {
    public static void main(String[] args) {
        List<String> names = List.of("Akbar", "Hasadi", "Putra", "Siregar");
        names.forEach(name -> System.out.println(name));
        names.forEach(System.out::println);
    }
}
```

### Collection.removeIf

```java
public class RemoveIfApp {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>(
                List.of("Akbar", "Hasadi", "Putra", "Siregar")
        );
        names.removeIf(name -> name.length() > 5);
    }
}
```

### Map.forEach

```java
public class MapForEachApp {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>(Map.of(
                "Akbar", 1,
                "Hasadi", 2,
                "Putra", 3,
                "Siregar", 4
        ));
        map.forEach((first, second) -> System.out.println(first + " " + second));
    }
}
```

Dan lain-lainnya, selebihnya cek isi Source Code dari Java Collection

---

## <span name="lambda-lazy-parameter">Lambda Sebagai Lazy Parameter</span>

### Lazy Parameter

- Java tidak memiliki fitur Parameter Lazy seperti di bahasa Scala
- Lazy Parameter artinya, Parameter tersebut hanya akan dieksekusi ketika gunakan
- Untungnya, dengan menggunakan Lambda kita bisa membuat Parameter layaknya Lazy Parameter

### Bukan Lazy Parameter

```java
public class NonLazyParameterApp {
    public static void main(String[] args) {
        testScoreNonLambda(90, "Akbar");
    }

    public static void testScoreNonLambda(int score, String name) {
        if (score > 80) {
            System.out.println("Selamat " + name + ", Anda Lulus");
        } else {
            System.out.println("Coba Lagi Tahun Depan");
        }
    }
}
```

### Lazy Parameter

```java
public class LazyParameterApp {
    public static void main(String[] args) {
        testScoreLambda(90, () -> getName());
        testScoreLambda(90, LazyParameterApp::getName);
    }

    public static void testScoreLambda(int score, Supplier<String> name) {
        if (score > 80) {
            System.out.println("Selamat " + name.get() + ", Anda Lulus");
        } else {
            System.out.println("Coba Lagi Tahun Depan");
        }
    }

    public static String getName() {
        System.out.println("function getName() dipanggil");
        return "Akbar";
    }
}
```

---

## <span name="lambda-optional">Lambda di Optional</span>

### Optional Class

- Di Java 8 tersedia sebuah class baru bernama `Optional` yang berada di package `java.util`
- Class ini digunakan sebagai wrapper untuk value yang bisa bernilai null
- Optional didesain agar kita lebih mudah ketika beroperasi dengan object yang bisa null
- Karena `NullPointerException` adalah salah satu hal yang sering sekali ditemui oleh Programmer Java

### Menggunakan Optional

```java
public class OptionalApp {
    public static void main(String[] args) {
        sayHello("Akbar");
        sayHello(null);
    }

    public static void sayHello(String name) {
        Optional<String> optionalName = Optional.ofNullable(name);

        // anonymous class
        Optional<String> optionalUpperAnon = optionalName.map(new Function<String, String>() {
            @Override
            public String apply(String name) {
                return name.toUpperCase();
            }
        });

        // lambda
        Optional<String> optionalUpperLambda = optionalName.map(name1 -> name1.toUpperCase());

        // method reference
        Optional<String> optionalUpperMethodRef = optionalName.map(String::toUpperCase);

        optionalUpperMethodRef.ifPresent(nameUpper -> System.out.println("Hello, " + nameUpper));
    }
}
```

### Mengambil Data Optional

```java
public class DataOptionalApp {
    public static void main(String[] args) {
        sayHello("Akbar");
        sayHello(null);
    }

    public static void sayHello(String name) {
        String nameUpperCase = Optional.ofNullable(name)
                .map(String::toUpperCase)
                .orElseGet(() -> "Tanpa Nama");
        System.out.println("Hello, " + nameUpperCase);
    }
}
```