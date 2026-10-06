🎯 Canvas do Projeto Final --- App Android

Como usar: este é o primeiro documento do projeto. Preencha em grupo, em
uma única aula, antes de escrever qualquer linha de código. Cada bloco
tem no máximo 5 linhas --- se não couber, o projeto está grande demais.
Depois de preenchido e validado pelo professor, ele vira a base do
PRD.md.

🧩 Bloco 1 --- Nome e pitch do app

Nome do app: (máx. 30 caracteres --- é o mesmo que vai na loja)

Pitch em uma frase:

O Beta ajuda empresas de turismo a organizar viagens, passageiros,
pagamentos e reservas de assentos sem precisar controlar essas
informações manualmente ou em listas separadas."

😖 Bloco 2 --- Problema

Qual dor real vocês estão resolvendo? Descrevam uma situação concreta
que alguém vive hoje.

Como esse problema é resolvido hoje (sem o app)?

As reservas precisam ser organizadas manualmente, dificultando a
visualização de quem está confirmado, quem pagou, quem cancelou e quais
assentos ainda estão disponíveis em cada viagem.

👥 Bloco 3 --- Público-alvo

Para quem é o app? Sejam específicos (idade, contexto, com que
frequência usariam).

Perfil principal: Pequenas empresas de turismo e responsáveis pela
organização de viagens.

Quando/onde usam: Durante o cadastro, organização e acompanhamento das
viagens e reservas.

Uma pessoa real que testaria o app: Betânia, responsável pela empresa de
turismo que apresentou o problema.

💡 Bloco 4 --- Solução em uma tela

Descreva o que a tela principal mostra e o que o usuário consegue fazer
nela.

A tela principal mostrará as viagens cadastradas, permitindo que o
usuário escolha uma viagem para consultar seus detalhes e realizar uma
reserva.

A tela principal lista: As viagens disponíveis, com destino e data.

A ação principal do usuário é: Escolher uma viagem e selecionar um
assento disponível.

Depois de agir, o usuário vê: A confirmação da reserva e o assento
escolhido.

✅ Bloco 5 --- Funcionalidades do MVP

Máximo de 4 funcionalidades. Se tiver mais, corte. Lembre: qualidade
acima de complexidade.

🚫 Bloco 6 --- Fora do escopo

O que o app não vai fazer nesta entrega. Escrever isso aqui protege
vocês de perder o prazo.

❌Pagamento online dentro do aplicativo.

❌ Sistema de chat ou comunicação entre passageiros.

❌ Notificações push e integração com WhatsApp.

❌ Sincronização em nuvem ou sistema completo para múltiplas empresas.

Sugestões comuns de coisas a deixar de fora: login/cadastro,
notificações push, chat, mapa, pagamento, modo offline completo,
sincronização em nuvem.

⚙️ Bloco 7 --- Caminho técnico

Marque uma opção (as três valem a mesma nota):

Opção A --- Room: dados salvos no próprio celular (lista de compras,
agenda, diário de treino, controle financeiro)

Opção B --- Retrofit: dados vindos de uma API pública (notícias, filmes,
feed, clima)

Opção C --- Desafio: API + salvar favoritos localmente

Se escolheu B ou C --- qual API? (link da documentação + precisa de
chave? é gratuita?)

Bibliotecas que o grupo vai usar:

Kotlin

Jetpack Compose

Room

Android Jetpack

Git/GitHub

Onde entra o try/catch? (qual operação pode falhar: banco vazio,
internet caindo, API fora do ar, campo em branco)

O try/catch será utilizado principalmente nas operações que envolvem o
armazenamento e recuperação dos dados, evitando que erros façam o
aplicativo fechar inesperadamente.

Pode falhar: Salvamento, alteração ou exclusão de uma viagem ou reserva.

O usuário vê a mensagem: Não foi possível realizar esta ação. Tente
novamente."

Também serão realizadas validações para impedir, por exemplo, que uma
reserva seja realizada em um assento que já esteja ocupado.

🎨 Bloco 8 --- Identidade visual

👤 Bloco 9 --- Equipe, papéis e riscos

Todos programam. O "papel" define quem responde por aquela parte, não
quem trabalha sozinho.

Riscos --- o que pode dar errado e o plano B:

🤖 Bloco 10 --- Acordo de trabalho com IA

A implementação pode ser feita com o Gemini no Android Studio. Vocês
orientam, ele digita --- e cada integrante precisa saber explicar o que
entrou no projeto. Regras completas em docs/USO_DE_IA.md.

Três regras que vamos escrever no nosso AGENTS.md (o arquivo que diz à
IA como trabalhar no nosso projeto):

1.  A IA deve explicar as alterações realizadas quando solicitado e não
    deve adicionar funcionalidades fora do escopo definido no PRD.

2.  Todo código gerado ou alterado pela IA deve ser revisado e testado
    por um integrante da equipe antes de ser aceito.

3.  A IA deve seguir a arquitetura, tecnologias e padrões definidos pelo
    grupo, evitando alterações desnecessárias no projeto.

Combinados do grupo:

Ninguém clica Accept no Agent Mode sem ler a mudança inteira.

Quem aceitou o código escreve o comentário de fronteira do arquivo.

Antes de cada marco, revisamos juntos: alguém aqui não entende alguma
parte?

Nenhuma chave de API ou senha vai para o prompt.

Outro combinado nosso:

Como vamos garantir que todos entendem tudo:

Quem implementar uma funcionalidade deverá apresentar aos outros
integrantes como ela funciona. O grupo também fará revisões em conjunto
antes dos principais marcos e cada integrante deverá realizar pequenas
alterações no projeto individualmente.

🗓️ Bloco 11 --- Marcos até 10/12

🏁 Bloco 12 --- Definição de pronto

O grupo só considera o app pronto quando todas estas frases forem
verdadeiras:

O app abre e não fecha sozinho depois de 5 minutos de uso.

A tela principal mostra dados reais (não texto de exemplo fixo no
código).

A ação principal funciona e o resultado aparece na tela.

Quando algo falha, aparece uma mensagem clara --- o app não quebra.

O app tem nome, ícone e cor próprios (nada de ícone padrão do Android).

Duas pessoas de fora do grupo instalaram o .apk e conseguiram usar sem
explicação.

O README.md explica o que o app faz, com o que foi feito e como gerar o
build.

O docs/USO_DE_IA.md e o AGENTS.md estão preenchidos.

Cada integrante consegue abrir o projeto e fazer uma mudança pequena
sozinho --- trocar um texto, acrescentar um campo, mudar a ordem da
lista.

Todo arquivo nosso tem o comentário de fronteira escrito por nós.

✍️ Validação do professor

\| Grupo nº \| Integrantes (3 a 4) \| Alexsandro Soares Ana Beatrys
Cauanne Victória Laryssa domingos Julia Allana Turma \| 3º ano A ---
Ensino Médio Repositório \| https://github.com/cvmms16/beta Data de
preenchimento \| 16/09/2026 Entrega final \| 10/12/2026

# \| Funcionalidade \| Essencial? \| Quem faz

F1 \| Cadastrar e visualizar viagens \| Sim \| Administradora F2 \|
Visualizar a planta do ônibus e os assentos disponíveis \| Sim \|
Administradora F3 \| Realizar, cancelar e consultar reservas \| Sim \|
Administradora F4 \| Controlar o status de pagamento dos passageiros \|
Sim \| Administradora

Item \| Definição do grupo Nome exibido (strings.xml) \| Beta Cor
principal (hex, em Color.kt) \| #ffc222 Ideia do ícone (512×512) \| A
logo apresenta o nome "Vai de Beta Turismo" em destaque, com as cores
azul e amarelo, além de elementos que remetem a viagens, como um ônibus,
um avião, o sol e linhas de movimento. A composição transmite a ideia de
turismo, viagem, transporte e aventura. applicationId \|
br.edu.ifpe.beta Versão inicial \| 1.0 (versionCode 1)

Integrante \| Papel principal \| Responsável por Alexsandro Soares e
Laryssa Vitória \| Dev / telas \| Interfaces e navegação Júlia \| Dev /
dados (Room ou Retrofit) \| Room, entidades e operações do banc Cauanne
Vitòria \| Design e identidade visual \| Cores, ícone e organização
visual ana \| Documentação, build e entrega \| README, documentação,
testes e builds

Risco \| Plano B A implementação da planta dos ônibus ficar muito
complexa \| Criar uma planta visual mais simples, mantendo a seleção e o
status dos assentos. O grupo não conseguir implementar todas as
funcionalidades \| Priorizar as quatro funcionalidades do MVP e retirar
funcionalidades extras.

Marco \| Prazo \| Como se comprova no GitHub M1 --- Canvas preenchido +
repositório criado \| 16/09 \| CANVAS.md no main M2 --- PRD aprovado +
telas rascunhadas \| 30/09 \| PRD.md + imagens em docs/ M3 ---
Funcionalidade base rodando \| 21/10 \| tela principal lista dados + 1
ação + try/catch M4 --- Dados completos (Room/Retrofit) e erros tratados
\| 11/11 \| commits da camada de dados M5 --- Identidade visual + .apk
de release testado \| 25/11 \| ícone, cores, .apk testado por 2 pessoas
de fora M6 --- .aab + material de loja + README.md \| 02/12 \| pasta
loja/ + README.md completo Entrega e apresentação \| 10/12 \| tag v1.0
no repositório

\| Data \| Situação \| ( ) Aprovado ( ) Aprovado com ajustes ( ) Refazer
Observações \|
