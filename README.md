# 🚢 Battleship Game 🎉

Welcome to **Battleship**, a classic naval combat game implemented in Java! Your mission is to sink all enemy ships before yours are destroyed.

---

## 🚀 Getting Started

### ✅ Requirements

- **Java 8 or higher**
- **Terminal or Command Prompt**
- _(Optional)_ IDE such as IntelliJ IDEA, Eclipse, or VS Code with Java support

---

## 🛠 Installation & Run

```bash
# Compile all .java files
javac *.java

# Run the game
java Game
```

## 🎮 How to Play

### 1. 📝 Enter Player Names

- You’ll be prompted to enter Player 1’s name.

- Choose whether to play against the computer:

- Enter Y for Computer opponent.

- Enter N and provide Player 2’s name for human opponent.

### 2. ⚓ Ship Placement

- You have two options for placing your ships:

- Automatic Placement (random positions)

- Manual Placement

### 3. 📍 Manual Placement Format:

```bash
<Letter><Number> <H|V>
```

- Letter: Row (A–J)

- Number: Column (1–10)

- H: Horizontal (→)

- V: Vertical (↓)

## 🧩 OOP Principles Applied

### 1. 🔒 Encapsulation

- Classes such as Board, Ship, Player, and GameHelper encapsulate their internal state (e.g., grids, lists of ships) - and provide controlled interfaces (methods like placeShip(), receiveShot(), display()).

### 2. 🔄 Inheritance & Polymorphism

- Abstract class Player defines common behaviors and interface.

- Concrete subclasses include:

- HumanPlayer: Accepts player input via the terminal.

- ComputerPlayer: Generates moves automatically.

- Polymorphic method calls (nextShot(), placeShips()) allow Game to interact uniformly with both human and computer players.

### 3. 🎯 Abstraction

- High-level game logic (setup, game loop, win conditions) is abstracted and managed by Game.java. Low-level details (like how ships are placed or shots selected) are delegated to specific classes.

### 4. 🧱 Composition

- Player composed of a Board and fleet of Ship objects.

- Board composed of a two-dimensional grid that manages hits and misses.

### 5. 📌 Single Responsibility Principle

- Each class is responsible for exactly one aspect of functionality:

- Game: Manages overall flow and game state.

- HumanPlayer and ComputerPlayer: Handle specific input logic and AI strategies.

- Board: Manages grid status and interactions.

- Ship: Tracks individual ship status, hits, and sinking logic.

- GameHelper: Parses and validates player input.

- BoardPlacer: Implements strategies for ship placement.

## 🏆 Winning the Game

- Sink all of your opponent's ships to win!

- Upon victory, the following message appears:
