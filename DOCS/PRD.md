


# PRD — Vai de Beta Turismo

## 1. Identificação do Projeto

Nome do aplicativo: Beta
Nome da solução: Vai de Beta Turismo
Turma: 3º A
Versão: 1.0
Plataforma: Android
Application ID: br.edu.ifpe.beta

## 2. Visão Geral

O Vai de Beta Turismo é um aplicativo Android desenvolvido para auxiliar a administração das viagens da Beta Turismo.

O aplicativo será utilizado somente pela administradora Betânia, que poderá cadastrar e organizar viagens, escolher os ônibus de cada viagem, visualizar os mapas de assentos e controlar os passageiros e seus pagamentos.

Não haverá uma área destinada aos passageiros. Todo o gerenciamento será realizado pela administradora.

## 3. Problema

O controle de viagens, passageiros, assentos e pagamentos pode ser feito de forma manual, dificultando a organização das informações.

O aplicativo tem como objetivo centralizar essas informações em um único sistema, facilitando o controle das viagens e permitindo visualizar rapidamente quais passageiros estão em cada ônibus e quais pagamentos foram realizados.

## 4. Público-Alvo

O aplicativo será destinado exclusivamente à administradora da Beta Turismo, Betânia.

Não haverá diferentes tipos de usuários ou níveis de acesso no MVP.

## 5. Objetivo do Aplicativo

O aplicativo deverá permitir que a administradora:

* Cadastre viagens
* Edite viagens
* Exclua viagens
* Escolha os ônibus de cada viagem
* Visualize o mapa de assentos de cada ônibus
* Cadastre passageiros em seus respectivos assentos
* Edite e remova passageiros
* Visualize nome, telefone, assento e ônibus de cada passageiro
* Controle o status de pagamento dos passageiros

## 6. Fluxo Principal

O fluxo principal do aplicativo será:

**Tela inicial → Viagem → Ônibus → Mapa de assentos → Passageiro**

Na tela inicial, a administradora visualizará suas viagens.

Ao selecionar uma viagem, serão exibidas as informações da viagem e os ônibus escolhidos para ela.

Ao clicar em um ônibus, seu respectivo mapa de assentos será aberto.

A administradora poderá selecionar um assento e cadastrar ou editar o passageiro daquele assento.

## 7. MVP

### F1 — Cadastro de Viagem

A administradora poderá cadastrar uma nova viagem informando:

* Nome da viagem
* Destino
* Data
* Informações adicionais
* Imagem de fundo da viagem
* Ônibus da viagem

### F2 — Gerenciamento de Viagens

A administradora poderá:

* Visualizar todas as viagens
* Abrir uma viagem
* Editar uma viagem
* Excluir uma viagem
* Visualizar as informações cadastradas

### F3 — Ônibus

Durante o cadastro da viagem, a administradora poderá escolher os ônibus que farão parte dela.

Os ônibus disponíveis inicialmente serão:

* G7
* DD

Uma viagem poderá ter um ou mais ônibus.

Os ônibus e seus respectivos mapas de assentos ficarão previamente cadastrados no banco de dados.

A administradora apenas selecionará quais ônibus farão parte da viagem.

### F4 — Mapa de Assentos

Os ônibus escolhidos ficarão disponíveis dentro da viagem.

Ao clicar em um ônibus, o aplicativo abrirá diretamente o mapa de assentos correspondente.

Cada ônibus terá seu próprio mapa e seus próprios passageiros.

Exemplo:

Viagem: Natal

* G7 1
* DD 1

Ao clicar no G7 1, será aberto o mapa de assentos do G7 1.

Ao clicar no DD 1, será aberto o mapa de assentos do DD 1.

Caso a viagem possua mais de um ônibus, cada um terá seu próprio mapa e seus próprios passageiros.

### F5 — Cadastro de Passageiro

A administradora poderá cadastrar um passageiro em determinado assento.

Informações:

* Nome
* Telefone
* Assento
* Ônibus
* Informações adicionais

Exemplo:

Ana
Telefone: (81) 99999-9999
Ônibus: G7 1
Assento: 13

### F6 — Edição e Exclusão de Passageiros

A administradora poderá:

* Editar os dados de um passageiro
* Alterar seu assento
* Alterar seus dados
* Remover o passageiro

### F7 — Controle de Pagamento

Cada passageiro terá um status de pagamento.

O status poderá ser alterado por meio de uma caixa de seleção simples:

☐ Não pago
☑ Pago

A administradora poderá alterar o status sempre que necessário.

### F8 — Lista de Passageiros

O aplicativo deverá apresentar uma lista com os passageiros cadastrados.

A lista deverá mostrar:

* Nome
* Telefone
* Assento
* Ônibus
* Status do pagamento

## 8. Funcionalidades

### RF01 — Cadastro de viagem

O sistema deve permitir o cadastro de novas viagens.

### RF02 — Edição de viagem

O sistema deve permitir alterar os dados de uma viagem cadastrada.

### RF03 — Exclusão de viagem

O sistema deve permitir excluir uma viagem.

### RF04 — Imagem da viagem

O sistema deve permitir adicionar uma imagem para representar a viagem.

### RF05 — Escolha dos ônibus

O sistema deve permitir escolher um ou mais ônibus para uma viagem durante seu cadastro ou edição.

### RF06 — Ônibus

O sistema deverá possuir inicialmente os ônibus G7 e DD.

### RF07 — Mapas de ônibus

Cada ônibus deverá possuir seu mapa de assentos previamente configurado no banco de dados.

### RF08 — Acesso ao mapa

Ao clicar em um ônibus dentro da viagem, o sistema deverá abrir diretamente o mapa de assentos correspondente.

### RF09 — Identificação dos ônibus

Quando houver mais de um ônibus na mesma viagem, o sistema deverá permitir identificar cada ônibus separadamente.

### RF10 — Cadastro de passageiro

O sistema deve permitir cadastrar um passageiro em determinado assento de determinado ônibus.

### RF11 — Nome do passageiro

Cada assento ocupado deverá apresentar o nome do passageiro relacionado.

### RF12 — Telefone do passageiro

O sistema deverá armazenar o telefone do passageiro.

### RF13 — Edição de passageiro

O sistema deverá permitir editar os dados do passageiro.

### RF14 — Exclusão de passageiro

O sistema deverá permitir remover um passageiro e liberar o assento.

### RF15 — Controle de assentos

O sistema deverá impedir que dois passageiros sejam cadastrados no mesmo assento do mesmo ônibus.

### RF16 — Status de pagamento

O sistema deverá permitir marcar o pagamento como pago ou não pago.

### RF17 — Lista de passageiros

O sistema deverá apresentar os passageiros cadastrados com seus respectivos dados.

### RF18 — Associação dos dados

Cada passageiro deverá estar associado à sua viagem, ônibus e assento.

### RF19 — Mensagens de erro

O sistema deverá informar quando houver dados obrigatórios não preenchidos ou alguma operação inválida.

## 9. Requisitos Não Funcionais

O aplicativo deverá:

* Ser desenvolvido para Android
* Utilizar Kotlin
* Utilizar Jetpack Compose
* Utilizar Material 3
* Utilizar Room para armazenamento local
* Utilizar Navigation Compose
* Utilizar Coroutines e Flow quando necessário
* Possuir interface simples e fácil de utilizar
* Manter os dados armazenados mesmo após fechar o aplicativo
* Possuir funcionamento estável durante o uso

## 10. Tecnologias

* Kotlin
* Android Studio
* Jetpack Compose
* Material 3
* Room
* Navigation Compose
* Coroutines
* Flow
* Git
* GitHub

## 11. Entidades Principais

### Viagem

Representa uma viagem cadastrada pela administradora.

Dados:

* ID
* Nome
* Destino
* Data
* Imagem
* Informações adicionais

Uma viagem poderá possuir um ou mais ônibus.

### Ônibus

Representa um ônibus utilizado em uma viagem.

Dados:

* ID
* Modelo
* Identificação
* Imagem
* Quantidade de assentos
* Configuração do mapa

Os ônibus G7 e DD e seus respectivos mapas de assentos ficarão previamente cadastrados no banco de dados.

A administradora selecionará o ônibus que fará parte da viagem.

### Passageiro

Representa uma pessoa cadastrada em uma viagem.

Dados:

* ID
* Nome
* Telefone
* Informações adicionais

### Reserva

Representa a relação entre passageiro, viagem, ônibus e assento.

Dados:

* ID
* Passageiro
* Viagem
* Ônibus
* Número do assento
* Status

### Pagamento

Representa o status do pagamento de uma reserva.

Dados:

* ID
* Reserva
* Status do pagamento

## 12. Relacionamento das Entidades

O relacionamento principal será:

**Viagem → Ônibus → Reserva → Passageiro → Pagamento**

Uma viagem possui um ou mais ônibus.

Cada ônibus possui uma configuração de mapa de assentos.

Cada reserva está relacionada a um passageiro, a um ônibus e a um assento.

Cada passageiro poderá possuir uma reserva.

Cada reserva possuirá um status de pagamento.

## 13. Telas do Aplicativo

### Tela 1 — Viagens

Será a tela inicial do aplicativo.

Deverá apresentar:

* Lista de viagens cadastradas
* Nome da viagem
* Destino
* Data
* Imagem da viagem
* Botão para adicionar uma nova viagem

A administradora poderá editar ou excluir uma viagem.

### Tela 2 — Cadastro de Viagem

A administradora poderá informar:

* Nome
* Destino
* Data
* Informações adicionais
* Imagem
* Ônibus

Nesta mesma tela será possível escolher os ônibus que farão parte da viagem.

### Tela 3 — Detalhes da Viagem

Apresentará:

* Nome da viagem
* Destino
* Data
* Imagem
* Informações adicionais
* Ônibus

Os ônibus escolhidos aparecerão nessa tela.

Exemplo:

Natal

G7 1
DD 1

Ao clicar em um ônibus, o aplicativo abrirá diretamente o mapa de assentos daquele ônibus.

### Tela 4 — Mapa do Ônibus

Apresentará o mapa de assentos correspondente ao ônibus selecionado.

Cada assento poderá apresentar:

* Número do assento
* Nome do passageiro, quando ocupado
* Indicação de assento disponível ou ocupado

Ao selecionar um assento, a administradora poderá cadastrar ou editar o passageiro.

Também poderá ser apresentada a lista de passageiros relacionada ao ônibus.

### Tela 5 — Passageiro

Permite cadastrar ou editar os dados do passageiro.

Campos:

* Nome
* Telefone
* Assento
* Informações adicionais
* Status do pagamento

### Tela 6 — Lista de Passageiros

Apresentará os passageiros da viagem ou do ônibus selecionado.

Informações:

* Nome
* Telefone
* Assento
* Ônibus
* Pagamento

A administradora poderá editar ou excluir um passageiro.

## 14. Tratamento de Erros

O aplicativo deverá apresentar mensagens quando:

* Nome da viagem não for informado
* Data não for informada
* Nenhum ônibus for escolhido
* Nome do passageiro não for informado
* Tentarem ocupar um assento já ocupado
* Algum dado obrigatório estiver faltando
* Ocorrer algum erro no armazenamento dos dados

## 15. Identidade Visual

A identidade visual deverá representar a Beta Turismo, utilizando uma interface simples, organizada e fácil de utilizar.

As telas deverão priorizar:

* Boa visualização das informações
* Organização dos assentos
* Facilidade para localizar passageiros
* Identificação clara dos pagamentos
* Navegação simples

## 16. Application ID e Versão

Application ID:

br.edu.ifpe.beta

Versão inicial:

1.0

## 17. Equipe

Equipe responsável pelo desenvolvimento do projeto:

* Julia
* Betânia
* Demais integrantes definidos pela equipe

## 18. Riscos

Principais riscos:

* Erros na configuração dos mapas de assentos
* Cadastro incorreto de passageiros
* Conflito de assentos
* Perda de dados
* Dificuldades na implementação do banco de dados
* Problemas de navegação entre as telas

## 19. Uso de Inteligência Artificial

A inteligência artificial poderá ser utilizada como apoio durante o desenvolvimento, principalmente para:

* Auxiliar na identificação de erros
* Explicar conceitos
* Sugerir soluções para problemas de código
* Auxiliar na documentação
* Apoiar a organização do projeto

O código deverá ser compreendido e revisado pela equipe antes de ser utilizado.

## 20. Cronograma

### Etapa 1

Definição do projeto e organização do PRD.

### Etapa 2

Criação das telas principais.

### Etapa 3

Implementação do banco de dados.

### Etapa 4

Cadastro e gerenciamento de viagens.

### Etapa 5

Implementação dos ônibus e mapas de assentos.

### Etapa 6

Cadastro e gerenciamento de passageiros.

### Etapa 7

Implementação do controle de pagamentos.

### Etapa 8

Testes e correções.

### Etapa 9

Finalização e apresentação do aplicativo.

## 21. Critérios de Aceitação

O aplicativo será considerado funcional quando:

* A administradora conseguir cadastrar uma viagem
* A administradora conseguir editar e excluir uma viagem
* A administradora conseguir adicionar uma imagem à viagem
* A administradora conseguir escolher os ônibus da viagem
* Os ônibus G7 e DD estiverem disponíveis
* Cada ônibus possuir seu próprio mapa de assentos
* Ao clicar no ônibus, seu mapa for aberto diretamente
* A administradora conseguir cadastrar passageiros
* Cada passageiro estiver associado ao assento correto
* O sistema impedir dois passageiros no mesmo assento
* A administradora conseguir editar e excluir passageiros
* A administradora conseguir visualizar a lista de passageiros
* A administradora conseguir marcar o pagamento como pago ou não pago
* Os dados permanecerem salvos no aplicativo

## 22. Entregáveis

* Aplicativo Android funcional
* Código-fonte
* Banco de dados local
* Mapas dos ônibus G7 e DD
* Documentação do projeto
* PRD
* Repositório GitHub

## 23. Definition of Done

Uma funcionalidade será considerada concluída quando:

* Estiver implementada
* Estiver funcionando corretamente
* Estiver integrada ao restante do aplicativo
* Tiver sido testada
* Não apresentar erros conhecidos que impeçam seu funcionamento
* Estiver de acordo com os requisitos definidos neste PRD

**Agora a estrutura de entidades está coerente:** não existe mais a entidade “Ônibus da Viagem”. **Ônibus é uma única entidade**, e G7/DD ficam como os ônibus/configurações disponíveis. O mapa também não virou uma entidade separada.
