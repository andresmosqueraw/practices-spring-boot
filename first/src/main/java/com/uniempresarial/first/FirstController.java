package com.uniempresarial.first;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirstController {
    // Petición
    @GetMapping(value = "saludar", produces=MediaType.TEXT_PLAIN_VALUE)
    public String greeting() {
        return "Hello World";
    }


    @GetMapping(value="add/{num1}/{num2}")
    public double add(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1 + num2;
    }

    @GetMapping(value="sub/{num1}/{num2}")
    public double sub1(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1 - num2;
    }

    @RequestMapping(value="sub", method = RequestMethod.GET)
    public double sub2(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        return num1 - num2;
    }

    // agrega validaciones al multiplicar
    @GetMapping(value="mul", produces=MediaType.TEXT_PLAIN_VALUE)
    public String mul(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        if (num1 == 0 || num2 == 0) {
            return "No se puede multiplicar por 0";
        }
        return String.valueOf(num1 * num2);
    }

    // agrega validaciones al dividir
    @GetMapping(value="div", produces=MediaType.TEXT_PLAIN_VALUE)
    public String div2(@RequestParam("num1") double num1, @RequestParam("num2") double num2) {
        if (num2 == 0) {
            return "No se puede dividir por 0";
        }
        return String.valueOf(num1 / num2);
    }

    @GetMapping(value="mod/{num1}/{num2}")
    public double mod(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return num1 % num2;
    }

    @GetMapping(value="pow/{num1}/{num2}")
    public double pow(@PathVariable("num1") double num1, @PathVariable("num2") double num2) {
        return Math.pow(num1, num2);
    }

    @GetMapping(value="sqrt/{num1}")
    public double sqrt(@PathVariable("num1") double num1) {
        return Math.sqrt(num1);
    }

    // Raiz cubica
    @GetMapping(value="cbrt/{num1}")
    public double cbrt(@PathVariable("num1") double num1) {
        return Math.cbrt(num1);
    }

    @GetMapping(value="abs/{num1}")
    public double abs(@PathVariable("num1") double num1) {
        return Math.abs(num1);
    }

    // Redondear hacia arriba
    @GetMapping(value="ceil/{num1}")
    public double ceil(@PathVariable("num1") double num1) {
        return Math.ceil(num1);
    }

    // Redondear hacia abajo
    @GetMapping(value="floor/{num1}")
    public double floor(@PathVariable("num1") double num1) {
        return Math.floor(num1);
    }

    // area de un circulo
    @GetMapping(value="area/{radio}")
    public double area(@PathVariable("radio") double radio) {
        return Math.PI * Math.pow(radio, 2);
    }

    // area de un cuadrado
    @GetMapping(value="areaCuadrado/{lado}")
    public double areaCuadrado(@PathVariable("lado") double lado) {
        return Math.pow(lado, 2);
    }

    // derivada de x^2
    @GetMapping(value="derivada/{x}")
    public double derivada(@PathVariable("x") double x) {
        return 2 * x;
    }

    // integral de x^2
    @GetMapping(value="integral/{a}/{b}")
    public double integral(@PathVariable("a") double a, @PathVariable("b") double b) {
        return (Math.pow(b, 3) - Math.pow(a, 3)) / 3;
    }

    // factorial
    @GetMapping(value="factorial/{n}")
    public double factorial(@PathVariable("n") double n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // fibonacci
        @GetMapping(value="fibonacci/{n}")
    public double fibonacci(@PathVariable("n") double n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }


    // maximo comun divisor
    @GetMapping(value="mcd/{a}/{b}")
    public double mcd(@PathVariable("a") double a, @PathVariable("b") double b) {
        if (b == 0) {
            return a;
        }
        return mcd(b, a % b);
    }

    // minimo comun multiplo
    @GetMapping(value="mcm/{a}/{b}")
    public double mcm(@PathVariable("a") double a, @PathVariable("b") double b) {
        return a * b / mcd(a, b);
    }

    // suma de los primeros n numeros naturales
    @GetMapping(value="sumaNaturales/{n}")
    public double sumaNaturales(@PathVariable("n") double n) {
        return n * (n + 1) / 2;
    }

    // suma de los primeros n numeros naturales pares
    @GetMapping(value="sumaNaturalesPares/{n}")
    public double sumaNaturalesPares(@PathVariable("n") double n) {
        return n * (n + 1);
    }

    // suma de los primeros n numeros naturales impares
    @GetMapping(value="sumaNaturalesImpares/{n}")
    public double sumaNaturalesImpares(@PathVariable("n") double n) {
        return n * n;
    }

    // suma de gauss
    @GetMapping(value="sumaGauss/{n}")
    public double sumaGauss(@PathVariable("n") double n) {
        return n * (n + 1) / 2;
    }

    // formulas famosas

    // formula de pitagoras
    @GetMapping(value="pitagoras/{a}/{b}")
    public double pitagoras(@PathVariable("a") double a, @PathVariable("b") double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    // formula general de segundo grado
    @GetMapping(value="formulaGeneral/{a}/{b}/{c}")
    public String formulaGeneral(@PathVariable("a") double a, @PathVariable("b") double b, @PathVariable("c") double c) {
        double discriminante = Math.pow(b, 2) - 4 * a * c;
        if (discriminante < 0) {
            return "No tiene solución en los reales";
        }
        double x1 = (-b + Math.sqrt(discriminante)) / (2 * a);
        double x2 = (-b - Math.sqrt(discriminante)) / (2 * a);
        return "x1 = " + x1 + ", x2 = " + x2;
    }

    // formula de Heron
    @GetMapping(value="heron/{a}/{b}/{c}")
    public double heron(@PathVariable("a") double a, @PathVariable("b") double b, @PathVariable("c") double c) {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    // formula de la distancia entre dos puntos
    @GetMapping(value="distancia/{x1}/{y1}/{x2}/{y2}")
    public double distancia(@PathVariable("x1") double x1, @PathVariable("y1") double y1, @PathVariable("x2") double x2, @PathVariable("y2") double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    // formula de la recta
    @GetMapping(value="recta/{x1}/{y1}/{x2}/{y2}")
    public String recta(@PathVariable("x1") double x1, @PathVariable("y1") double y1, @PathVariable("x2") double x2, @PathVariable("y2") double y2) {
        double m = (y2 - y1) / (x2 - x1);
        double b = y1 - m * x1;
        return "y = " + m + "x + " + b;
    }

    // formula de la circunferencia
    @GetMapping(value="circunferencia/{x}/{y}/{r}")
    public String circunferencia(@PathVariable("x") double x, @PathVariable("y") double y, @PathVariable("r") double r) {
        return "(x - " + x + ")^2 + (y - " + y + ")^2 = " + r + "^2";
    }

    // formula de la elipse
    @GetMapping(value="elipse/{a}/{b}")
    public String elipse(@PathVariable("a") double a, @PathVariable("b") double b) {
        return "x^2 / " + Math.pow(a, 2) + " + y^2 / " + Math.pow(b, 2) + " = 1";
    }

    // formula de la hipérbola
    @GetMapping(value="hiperbola/{a}/{b}")
    public String hiperbola(@PathVariable("a") double a, @PathVariable("b") double b) {
        return "x^2 / " + Math.pow(a, 2) + " - y^2 / " + Math.pow(b, 2) + " = 1";
    }

    // formula de la parabola
    @GetMapping(value="parabola/{p}")
    public String parabola(@PathVariable("p") double p) {
        return "y^2 = 4" + p + "x";
    }

    // formula de la esfera
    @GetMapping(value="esfera/{x}/{y}/{z}/{r}")
    public String esfera(@PathVariable("x") double x, @PathVariable("y") double y, @PathVariable("z") double z, @PathVariable("r") double r) {
        return "(x - " + x + ")^2 + (y - " + y + ")^2 + (z - " + z + ")^2 = " + r + "^2";
    }

    // formula del cilindro
    @GetMapping(value="cilindro/{r}/{h}")
    public String cilindro(@PathVariable("r") double r, @PathVariable("h") double h) {
        return "2π" + r + "(" + r + " + " + h + ")";
    }

    // formula del cono
    @GetMapping(value="cono/{r}/{h}")
    public String cono(@PathVariable("r") double r, @PathVariable("h") double h) {
        return "π" + r + "(" + r + " + " + Math.sqrt(Math.pow(h, 2) + Math.pow(r, 2)) + ")";
    }

    // formula de la piramide
    @GetMapping(value="piramide/{l}/{a}")
    public String piramide(@PathVariable("l") double l, @PathVariable("a") double a) {
        return l + " * " + a + " / 3";
    }

    // formula del prisma
    @GetMapping(value="prisma/{a}/{h}")
    public String prisma(@PathVariable("a") double a, @PathVariable("h") double h) {
        return a + " * " + h;
    }

    // formula del ortoedro
    @GetMapping(value="ortoedro/{a}/{b}/{c}")
    public String ortoedro(@PathVariable("a") double a, @PathVariable("b") double b, @PathVariable("c") double c) {
        return 2 + "(" + a + " * " + b + " + " + b + " * " + c + " + " + c + " * " + a + ")";
    }

    // formula del tetraedro
    @GetMapping(value="tetraedro/{a}")
    public String tetraedro(@PathVariable("a") double a) {
        return Math.sqrt(3) + " * " + Math.pow(a, 2) + " / 4";
    }

    // formula del octaedro
    @GetMapping(value="octaedro/{a}")
    public String octaedro(@PathVariable("a") double a) {
        return Math.sqrt(2) + " * " + Math.pow(a, 2) + " * " + Math.sqrt(3) + " / 3";
    }

    // formula del dodecaedro
    @GetMapping(value="dodecaedro/{a}")
    public String dodecaedro(@PathVariable("a") double a) {
        return 3 * Math.sqrt(25 + 10 * Math.sqrt(5)) + " * " + Math.pow(a, 3) / 4;
    }

    // formula del icosaedro
    @GetMapping(value="icosaedro/{a}")
    public String icosaedro(@PathVariable("a") double a) {
        return 5 * (3 + Math.sqrt(5)) + " * " + Math.pow(a, 3) / 12;
    }


}
