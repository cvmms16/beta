# AGENTS.md — Beta — Gestão de Viagens e Reservas

Este arquivo define as instruções que agentes de inteligência artificial devem seguir ao trabalhar neste repositório.

As regras são específicas do **Beta — Gestão de Viagens e Reservas** e devem ser consideradas em tarefas de análise, implementação, correção, testes e documentação.

## 1. Contexto e objetivo

O **Beta** é um aplicativo Android para a empresa de turismo **VaideBeta**, utilizado por **Betânia** para organizar viagens, ônibus, passageiros, reservas, assentos e situação de pagamento.

O aplicativo tem como objetivo substituir parte da organização manual das viagens por uma solução digital simples, organizada e confiável.

O agente deve trabalhar dentro do escopo definido pela equipe e não deve criar funcionalidades apenas por serem tecnicamente possíveis.

## 2. Usuário do aplicativo

O único usuário do aplicativo é **Betânia**.

Os passageiros são registros administrados por ela e não usuários do sistema.

Não implementar, sem decisão explícita da equipe:

- login ou cadastro de passageiros;
- área do passageiro;
- seleção de viagens pelo passageiro;
- reservas realizadas diretamente pelo passageiro;
- pagamentos realizados pelo passageiro.

## 3. Regras principais do projeto

### Viagens

O aplicativo deve permitir o cadastro de várias viagens.

Cada viagem possui, no mínimo:

- destino;
- data;
- ônibus utilizados.

Os dados de uma viagem devem permanecer independentes dos dados das demais.

### Ônibus

Uma viagem pode utilizar um ou mais ônibus.

Os ônibus possuem configurações de assentos previamente definidas pelo projeto.

As plantas dos ônibus são imagens fixas incluídas como recursos do aplicativo Android. Não criar sistema de upload ou edição livre dessas plantas sem decisão explícita da equipe.

### Reservas e assentos

Uma reserva relaciona:

- viagem;
- ônibus;
- passageiro;
- assento;
- situação do pagamento.

Regra fundamental:

> Um mesmo assento não pode ser reservado para duas pessoas na mesma viagem e no mesmo ônibus.

O mesmo número de assento pode existir em ônibus diferentes.

Ao cancelar ou remover uma reserva, o assento deve voltar a ficar disponível sem alterar indevidamente as demais reservas.

### Pagamento

O aplicativo apenas registra a situação do pagamento:

- `Pago`;
- `Pendente`.

O Beta não realiza pagamentos.

Não implementar Pix, cartão, gateway, checkout ou integração bancária sem decisão explícita da equipe.

## 4. Banco de dados

O armazenamento local utiliza **Room**, com **SQLite**.

As informações principais envolvem:

- viagens;
- passageiros;
- reservas;
- ônibus;
- assentos;
- situação do pagamento.

Ao alterar entidades, relacionamentos, DAOs ou consultas, o agente deve verificar os impactos nas funcionalidades existentes e preservar a consistência dos dados.

Não substituir o Room por outra solução sem decisão da equipe.

Não apagar, recriar ou alterar o banco de forma arbitrária.

## 5. Interface e tecnologias

O aplicativo utiliza:

- Kotlin;
- Android Studio;
- Jetpack Compose;
- Room;
- SQLite;
- Gradle.

A interface deve permanecer simples, clara e adequada ao uso administrativo de Betânia.

O fluxo deve ser coerente com a organização das viagens, ônibus, passageiros, assentos e reservas.

Novas bibliotecas ou tecnologias só devem ser adicionadas quando forem realmente necessárias.

## 6. Fora do escopo

Não adicionar ao Beta, salvo decisão explícita da equipe:

- sistema de passageiros;
- compra ou venda de passagens;
- pagamentos reais;
- Firebase ou backend;
- sincronização em servidor;
- GPS, mapas ou rastreamento;
- integração com WhatsApp ou e-mail;
- notificações externas;
- upload de plantas de ônibus;
- criação livre de plantas;
- inteligência artificial dentro do aplicativo;
- funcionalidades não relacionadas ao objetivo principal do projeto.

Essas restrições existem para controlar o escopo e podem ser alteradas somente por decisão da equipe.

## 7. Regras para alteração do código

Antes de modificar o projeto, o agente deve:

1. entender a tarefa;
2. localizar e analisar os arquivos envolvidos;
3. verificar como a funcionalidade existente funciona;
4. identificar possíveis impactos;
5. alterar somente o necessário.

O agente deve:

- preservar funcionalidades existentes;
- reutilizar código e componentes quando apropriado;
- evitar refatorações não relacionadas à tarefa;
- evitar dependências desnecessárias;
- não apagar código funcional sem justificativa;
- não alterar regras de negócio sem decisão da equipe.

A solução mais simples que atende corretamente ao requisito deve ser priorizada.

## 8. Validação

Alterações relevantes devem ser verificadas antes de serem consideradas concluídas.

Quando aplicável, verificar:

- compilação;
- navegação das telas afetadas;
- cadastro, edição e carregamento de dados;
- persistência no Room;
- reservas e assentos;
- bloqueio de assento já ocupado;
- liberação do assento após cancelamento;
- preservação das demais reservas.

O agente não deve afirmar que algo foi testado se não tiver sido realmente verificado.

Se um teste não puder ser realizado, essa limitação deve ser informada.

## 9. Trabalho com diferentes IAs

O projeto pode utilizar diferentes ferramentas de IA, como Gemini, GitHub Copilot, ChatGPT ou outras.

Todas devem seguir este arquivo e as decisões oficiais do projeto.

Uma IA não deve presumir decisões tomadas em conversas anteriores com outra IA.

Quando houver dúvida, deve consultar o código e a documentação do repositório antes de assumir uma regra.

Uma IA não deve desfazer uma alteração de outra IA apenas por preferência pessoal. Caso identifique um problema, deve explicar a razão e corrigir somente o necessário.

## 10. Fonte de verdade

Em caso de conflito de informações, considerar esta prioridade:

1. código atual do repositório;
2. requisitos e decisões oficiais da equipe;
3. documentação oficial do projeto;
4. este `AGENTS.md`;
5. contexto fornecido durante a tarefa.

Conversas anteriores com IAs não são fonte oficial quando contradizem o repositório ou a documentação atual.

O agente não deve inventar requisitos.

## 11. Uso de inteligência artificial

A inteligência artificial pode ser utilizada como ferramenta de apoio em qualquer etapa do desenvolvimento, incluindo programação, explicação de conceitos, correção de erros, testes e documentação.

O uso de IA não substitui a análise da equipe. Antes de incorporar uma sugestão gerada por IA, a equipe deve verificar se ela está de acordo com o projeto e compreender o que foi alterado.

O uso de IA deve ser registrado em:

`docs/USO_DE_IA.md`

O registro deve representar o uso real das ferramentas utilizadas no projeto.

## 12. Documentação

Cada documento deve cumprir sua finalidade.

O agente não deve duplicar informações desnecessariamente entre `README.md`, `CANVAS.md`, `PRD.md`, `AGENTS.md` e demais documentos.

Ao modificar documentação, manter consistência com o código atual e com as decisões oficiais da equipe.

## 13. Regra final

O agente deve contribuir para o desenvolvimento do Beta sem aumentar seu escopo desnecessariamente.

As prioridades são:

**clareza → simplicidade → funcionalidade → estabilidade → organização**

O objetivo é implementar corretamente o sistema definido pela equipe, preservando suas regras de negócio e suas funcionalidades existentes.
