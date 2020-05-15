# App Crypto News

O aplicativo consome uma API REST para buscar os dados referentes as notícias do mundo de cripto moedas.

A API utilizada foi a [NewsAPI](https://newsapi.org/)

**O aplicativo possui duas telas e elas são:**
  - 1º Tela para consultar as notícias por tipo de moeda selecionada ou todos os tipos de cripto moedas;
  - 2º Tela para visualizar os detalhes da notícia selecionada. Nessa tela é possível navegar até o site oficial.

**No desenvolvimento do projeto foram utilizadas as tecnologias descritas abaixo**

- Linguagem de Programação
  - 
  - Kotlin

- Componentes de Arquitetura e Android Jetpack
  -
  - Documentação
    - 
    - [Navigation](https://developer.android.com/guide/navigation)
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel#sharing)
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
    - [DataBinding](https://developer.android.com/topic/libraries/data-binding)
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
    - [Coroutines](https://developer.android.com/topic/libraries/architecture/coroutines)
    - [Fragments](https://developer.android.com/guide/components/fragments)
    - [Android KTX](https://developer.android.com/kotlin/ktx)
    
- Bibliotecas Externas
  - 
  - [Retrofit](https://square.github.io/retrofit/) é utilizada para fazer requisições HTTP a serviços Web
  - [Moshi](https://github.com/square/moshi) é uma moderna biblioteca JSON para Android, Kotlin e Java. Ela faz de forma fácil a conversão de um JSON para objetos Kotlin e Java.
  - [Koin](https://insert-koin.io/) é utilizada para fazer injeção de depedência
  - [Glide](https://github.com/bumptech/glide) é um rápido e eficiente gerenciamento de mídia open source e estrutura de carregamento de imagens para Android que envolve decodificação de mídia, memória e cache de disco, e agrupamento de recursos em uma interface simples e fácil de usar.
  
- Bibliotecas Internas
  -
  - [RecyclerView](https://developer.android.com/guide/topics/ui/layout/recyclerview) é utilizada para criar listas de informações, objetos, imagens que serão apresentados na tela
  - [Material Design](https://material.io/) é a orientação de código e projeto oficial do Google
  
- Design de Arquitetura
  - 
  - [MVVM](https://medium.com/involves-rocks/observa%C3%A7%C3%B5es-sobre-mvp-mvvm-e-outras-letras-c00656058f44) é o padrão de design de arquitetura de software que a Google indica para os novos desenvolvimento. Os novos componentes de arquitetura já são lançados com suporte a esse tipo de padrão 
  - [Repository](https://proandroiddev.com/the-real-repository-pattern-in-android-efba8662b754) é estratégia para abstrair o acesso aos dados. Ele é composto pelo código em uma aplicação que lida com o armazenamento e a recuperação de dados. [Mais detalhes](https://makingloops.com/why-should-you-use-the-repository-pattern/).
