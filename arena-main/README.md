# 🎮 Arena Matchmaking

**RA:** 235908-1 | **Aluno:** Erick Daniel Teixeira Vier  

---

## 📋 Regras do Sistema

* **CU1 (Times):** Só salva com 5 jogadores e capitão com rank > 2500.
* **CU2 (Matchmaking - Transacional):** Junta 2 times se a diferença de rank for < 500 e bloqueia ambos.
* **CU3 (Resultado):** Dá +25 pontos de rank para o vencedor, -25 para o perdedor e libera os times.

---

## 🚀 Como Testar (Porta 8080)

1. **Jogadores:** `POST` -> `/jogadores`
2. **Times:** `POST` -> `/times`
3. **Partida:** `POST` -> `/matchmaking/buscar-partida?idTimeA=1&idTimeB=2`
4. **Finalizar:** `POST` -> `/matchmaking/finalizar?idPartida=1&idVencedor=1`
