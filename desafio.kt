enum class Nivel { FACIL, INTERMEDIARIO, DIFICIL }

data class Usuario(val nome: String, val idade: Int, val formacao: Formacao)

data class ConteudoEducacional(var nome: String, val duracaoMeses: Int)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, var nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário: ${usuario.nome} matriculado com sucesso!")
    }
}

fun main() {

    val formacaoKotlin = Formacao("Kotlin", listOf(ConteudoEducacional("Funções e classes", 1),
        ConteudoEducacional("Desenvolvendo aplicativo para barbearia", 2)), Nivel.FACIL)
    val formacaoJava = Formacao("Java", listOf(ConteudoEducacional("Criando aplicativo Java", 4),
        ConteudoEducacional("Criando API para testes", 1)), Nivel.INTERMEDIARIO)
    val formacaoJavaScript = Formacao("JavaScript", listOf(ConteudoEducacional("Desenvolvendo site de e-commerce", 3),
        ConteudoEducacional("Criando jogo com Javascript", 2)), Nivel.DIFICIL)
    val formacaoHtml = Formacao("HTML", listOf(ConteudoEducacional("Criando uma Landing Page", 2),
        ConteudoEducacional("Desenvolvendo sistema de login", 1)), Nivel.FACIL)

    println("----------Lista de Alunos Cadastrados--------")
    formacaoKotlin.matricular(Usuario("Leandro", 36, formacaoKotlin))
    formacaoKotlin.matricular(Usuario("Noah", 29, formacaoKotlin))
    formacaoJava.matricular(Usuario("Thiago", 21, formacaoJava ))
    formacaoJavaScript.matricular(Usuario("Jorge", 37, formacaoJavaScript ))
    formacaoHtml.matricular(Usuario("Maria", 19, formacaoHtml ))
    formacaoHtml.matricular(Usuario("Joana", 31, formacaoHtml ))
    formacaoJavaScript.matricular(Usuario("Vitória", 21, formacaoJavaScript ))

    println("----------Total de Alunos Inscritos por Formação--------")
    println("Inscritos na formação Kotlin: ${formacaoKotlin.inscritos.size}\n" +
            "Inscritos na formação Java: ${formacaoJava.inscritos.size}\n" +
            "Inscritos na formação JavaScript: ${formacaoJavaScript.inscritos.size}\n" +
            "Inscritos na formação HTML: ${formacaoHtml.inscritos.size}\n" +
            "Total de inscritos na DIO: ${formacaoHtml.inscritos.size +
                    formacaoJava.inscritos.size + formacaoJavaScript.inscritos.size + formacaoKotlin.inscritos.size}")

    println("---------Nível de Dificuldade das Formações--------")
    println("Formação Kotlin: ${formacaoKotlin.nivel}")
    println("Formação Java: ${formacaoJava.nivel}")
    println("Formação JavaScript: ${formacaoJavaScript.nivel}")
    println("Formação HTML: ${formacaoHtml.nivel}")

    println("---------Imprimindo as informações de cada Formação--------")
    println(formacaoKotlin)
    println(formacaoJava)
    println(formacaoJavaScript)
    println(formacaoHtml)

    println("--------Imprimindo Usuários e suas Formações--------")
    val inscritos = formacaoJava.inscritos + formacaoKotlin.inscritos + formacaoHtml.inscritos + formacaoJavaScript.inscritos
    inscritos.forEach{
        println("Nome: ${it.nome} | Idade: ${it.idade} | Formação: ${it.formacao.nome}")
    }
}
