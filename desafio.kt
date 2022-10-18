import java.sql.DriverManager.println
import kotlin.collections.List

// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO } // class enum

data class Usuario(val nome: String, val  idade: Int)

data class ConteudoEducacional(var nome: String, val duracao: Int = 60, val nivel: Nivel )

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
    }
}

fun main() {
    val cursoA = ConteudoEducacional("Nocoes de Programacao", 120, Nivel.BASICO)
    val cursoB = ConteudoEducacional("Estrutura de dados e Servidor", 180, Nivel.INTERMEDIARIO)
    val cursoC = ConteudoEducacional("Inteligencia Artificial", 250, Nivel.AVANCADO)

    val formacao = Formacao("Ciencia da Computação", listOf(cursoA, cursoB, cursoC))

    val alunoA = Usuario("Frank",14)
    val alunoB = Usuario("Daniela",23)

    formacao.matricular(alunoA)
    formacao.matricular(alunoB)

    print("Formação: ${formacao.nome}")
    print("Conteudos:")
    for (conteudo in formacao.conteudos){
        print("-${conteudo.nome} (${conteudo.duracao} minutos) - Nivel: ${conteudo.nivel}")
    }
    print("Inscritos")
    for(incrito in formacao.inscritos){
        print("- ${incrito.nome} - ${incrito.idade}, anos")
    }

}

