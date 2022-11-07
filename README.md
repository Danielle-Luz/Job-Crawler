<h1 align="center">Job Crawler</h1>

<p align="center">
    <img alt="Badge indicando que o projeto foi criado em novembro de 2022" src="https://img.shields.io/badge/Data%20de%20cria%C3%A7%C3%A3o-Novembro%2F2022-blue">
    <img alt="Badge indicando que o status do projeto é 'concluído'" src="https://img.shields.io/badge/Status-Concluído-green">
</p>

<p align="center">
    • <a href="#Como acessar">Como acessar</a>
    • <a href="#descricao">Descrição</a>
    • <a href="#funcionalidades">Funcionalidades</a>
    • <a href="#tecnologias">Tecnologias</a>
    • <a href="#Desenvolvedora">Desenvolvedores</a>
</p>

<h2 id="Como acessar"> :computer_mouse: Como acessar?</h2>

Confira e utilize o projeto no <a href="https://danielle-luz.github.io/Job-Crawler/">github pages</a>.


<h2 id="descricao">:pencil2: Descrição</h2>
O JobCrawler é um site que exibe e endereça vagas de programador presentes em urls do site <a href="https://www.trabalhabrasil.com.br/">Trabalha Brasil</a> por meio de webscrapping, além disso permite o envio de um relatório por email das vagas encontradas.
O JobCrawler foi desenvolvido durante uma hackaton com duração de um dia e meio, proposta pela mesttra dentro do curso de desenvolvimento backend em java.

<h2 id="funcionalidades">:hammer: Funcionalidades</h2>
<div align=center>
    <img src="src/img/readme/kenbazar.gif">
</div>

- Webscrapping na URL indicada.
- Requisições para API.
- Filtragem de vagas por salário.
- Envio de relatório das vagas recebidas na requisição para o email informado.


<h2 id="tecnologias">:computer: Tecnologias</h2>
<p align="center">
    <a href="https://www.w3.org/html/">
    <img alt="Logo do HTML" src="https://img.icons8.com/color/48/000000/html-5--v1.png">
  </a>
  <a href="https://www.w3.org/Style/CSS/Overview.en.html">
    <img alt="Logo do CSS" src="https://img.icons8.com/color/48/000000/css3.png">
  </a>
  <a href="https://www.javascript.com/">
    <img alt="Logo do javascript" src="https://img.icons8.com/color/48/000000/javascript--v1.png">
  </a>
  <a href="">
    <img alt="Logo do spring boot" width=50 height=48 src="https://devkico.itexto.com.br/wp-content/uploads/2014/08/spring-boot-project-logo.png">
  </a>
  <a href="">
    <img alt="Logo do heroku" src="https://img.icons8.com/color/48/000000/heroku--v1.png">
  </a>
  <a href="">
    <img alt="Logo do maven"  width=50 height=48  src="https://upload.wikimedia.org/wikipedia/commons/thumb/7/7e/Apache_Feather_Logo.svg/640px-Apache_Feather_Logo.svg.png">
  </a>
  <a href="https://code.visualstudio.com/">
    <img alt="Logo do VS code" src="https://img.icons8.com/color/48/000000/visual-studio-code-2019.png">
  </a>
</p>

<h2 id="tecnologias">:computer: Tecnologias</h2>

* Endpoint: `/trabalhos`
* Método: `POST`
* Request body: `{ url: url.com }`
  * Url do Trabalha Brasil onde as vagas devem ser procuradas e retornadas.
* Retorno: Array de objetos com informações sobre a vaga.

<br>


* Endpoint: `/email`
* Método: `POST`
* Request body: `{ email: email.com }`
  * Obtém o email do usuário e envia um relatório para ele.
* Retorno: booleano indicando o status da requisição.

<h2 id="Desenvolvedora">:woman: Desenvolvedores</h2>

<p align="center">
  <a href="https://github.com/Danielle-Luz">
    <img width="120px" src="https://avatars.githubusercontent.com/u/99164019?v=4" alt="foto de uma mulher parda com o cabelo castanho, sorrindo levemente na frente de um fundo verde com bits">
  </a>
</p>

<p align="center">
Danielle da Luz Nascimento
</p>

<p align="center">
Backend e frontend
</p>

<p align="center">
<a href="https://www.linkedin.com/in/danielle-da-luz-nascimento/">@Linkedin</a>
</p>

<p align="center">
  <a href="https://github.com/Davi64Lima">
    <img width="120px" src="https://avatars.githubusercontent.com/u/102451543?v=4" alt="foto de homem sorrindo">
  </a>
</p>

<p align="center">
Davi Lima
</p>

<p align="center">
Frontend
</p>

<p align="center">
  <a href="https://github.com/EndryoMachado">
    <img width="120px" src="https://avatars.githubusercontent.com/u/89991280?v=4" alt="homem de cabelo cacheado de perfil">
  </a>
</p>

<p align="center">
Endryo Machado
</p>

<p align="center">
  <a href="https://github.com/NorsteinH">
    <img width="120px" src="https://avatars.githubusercontent.com/u/117535251?v=4" alt="foto de mochileiro admirando a paisagem">
  </a>
</p>

<p align="center">
Henrique Corrêa
</p>

