// [Template no Kotlin Playground](https://pl.kotl.in/WcteahpyN)

/**
 * Neste desafio, o programa exibe as informações da formação incluida os contéudos e os incritos.
 */
enum class Nivel { BASICO, INTERMEDIARIO, AVANCAD0} // class enum

/**
 * A classe usuario foi atualizada para ter um atributo "nome" e "idade" no construtor
 */
data class Usuario( val nome: String, val idade: Int)

/**
 * A classe ConteudoEducacional agora inclui um atributo "nivel" da enum classe.
 */
data class ConteudoEducacional(val nome: String, val duracao: Int = 60, val nivel: Nivel)

/**
 * Formacao é criada com esses conteudos
 */
data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)


    }
}

/**
 * Na função main feito os testes do programa, é adicionado os contéudos e os incritos usando o método
 * matricula.
 */
fun main() {

    val CursoA = ConteudoEducacional("Introdução á Programação", 120, Nivel.BASICO)
    val CursoB = ConteudoEducacional("Algoritmos e Estruturas de Dados", 180, Nivel.INTERMEDIARIO)
    val CursoC = ConteudoEducacional("Inteligência Artificial", 240, Nivel.AVANCAD0)

    val formacao = Formacao("Ciência da Computação", listOf(CursoA, CursoB, CursoC))

    val usuarioA = Usuario("Frank",18)
    val usuarioB = Usuario("Daniela", 22)
    val usuarioC = Usuario("Zilda",55)

    formacao.matricular(usuarioA)
    formacao.matricular(usuarioB)
    formacao.matricular(usuarioC)

    println("Formação: ${formacao.nome}")
    println("Contéudos:")
    for (conteudo in formacao.conteudos){
        println("- ${conteudo.nome} (${conteudo.duracao} minutos) - Nível: ${conteudo.nivel}")
    }

    println("Incritos:")
    for(incrito in formacao.inscritos){
        println("- ${incrito.nome} - ${incrito.idade}, anos")
    }
}