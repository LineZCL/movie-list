Lista de filmes 
======================

###Projeto

Projeto android, utilizando o Retrofit, dagger e com a arquitetura Clean Architecture. 

É uma lista de filmes retornada pela API do MovieDB. 

###Como o projeto está estruturado. 

Dado a arquitetura escolhida o projeto foi dividido em features. 

Em cada feature tem uma divisão de: 

- Model : fica os modelos referentes aquelas features. 
- Presenter: estão as classes com as regras de negócio. 
- View: classes que controlam somente a view (Activities) 
- Repository: classes que conectam ao serviço através do retrofit, e buscam ou enviam dados. 

###Setup do projeto. 

1. Baixe o código do git: https://github.com/LineZCL/movie-list 
2. Rode o gradle sync. 
3. Dê run no projeto. 

###Trabalhos futuros. 
- Adicionar testes. 
