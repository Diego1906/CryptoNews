# App Crypto News

O aplicativo consome uma API REST para buscar os dados referentes as notícias do mundo de cripto moedas.

O aplicativo possui duas telas sendo uma para consultar as notícias por tipo de moeda e a outra com os detalhes da notícia onde é possível navegar até o site oficial.

A API utilizada foi a [NewsAPI](https://newsapi.org/)


**No desenvolvimento do projeto foram utilizadas as tecnologias descritas abaixo**


- Linguagem de Programação
  - 
  - Kotlin

- Componentes de Arquitetura
  -
  - Documentação
    - 
    - [Navigation](https://developer.android.com/guide/navigation)
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel#sharing)
    - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata)
    - [DataBinding](https://developer.android.com/topic/libraries/data-binding)
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle)
    - [Coroutines](https://developer.android.com/topic/libraries/architecture/coroutines)
    
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
