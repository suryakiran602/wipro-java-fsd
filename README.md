# Wipro Java FSD

[![GitHub stars](https://img.shields.io/github/stars/suryakiran602/wipro-java-fsd.svg)](https://github.com/suryakiran602/wipro-java-fsd/stargazers) [![Forks](https://img.shields.io/github/forks/suryakiran602/wipro-java-fsd.svg)](https://github.com/suryakiran602/wipro-java-fsd/network) [![Open Issues](https://img.shields.io/github/issues/suryakiran602/wipro-java-fsd.svg)](https://github.com/suryakiran602/wipro-java-fsd/issues) [![Top language](https://img.shields.io/github/languages/top/suryakiran602/wipro-java-fsd.svg)](https://github.com/suryakiran602/wipro-java-fsd) [![License](https://img.shields.io/github/license/suryakiran602/wipro-java-fsd.svg)](https://github.com/suryakiran602/wipro-java-fsd)

A collection of Java assignments, exercises, mini-projects, and learning examples created while studying Full Stack Development (FSD) fundamentals. This repository demonstrates Java language features, object-oriented concepts, collections, I/O streams, multithreading, unit testing, and small project modules — useful for practice and teaching.

## Table of contents

- Repository structure
- Badges and status
- Prerequisites
- Quick examples (compile & run)
- Screenshots
- Recommended .gitignore & cleanup
- Contribution
- License

## Repository structure

- Arrays/                      - Array exercises and a small video store mini-project
- IOstreams/                   - File I/O examples and a small employee-management demo
- JunitLearning/               - Example Maven project with unit tests
- LanguageBasics/              - Basic Java language examples
- Multithread/                 - Multithreading examples and mini-projects
- StudentGradeCalculation/     - Sample project demonstrating package structure and exception handling
- abstractClasses/             - Abstract classes and interface examples
- collections/                 - Collections framework examples and lambda expressions
- logicBuilding/               - Algorithmic problems and logic practice
- wrapperclasses/              - Wrapper class examples and conversions

## Badges and status

- GitHub stars / forks / issues are shown above using Shields.io.
- Top language badge shows the dominant language detected by GitHub.
- License badge will update automatically when a LICENSE file is added.

If you add CI (GitHub Actions) or other services, paste the workflow badge here to show build status.

## Prerequisites

- Java JDK 8 or newer
- Maven (for Maven subprojects such as `JunitLearning`)

## Quick examples (compile & run)

Example 1 — run a root assignment file (simple, no packages):

```bash
cd "C:\Users\HARISH\Downloads\WiproJava-main2\WiproJava-main"
javac Assignment1.java
java Assignment1
```

Example 2 — compile and run a single-file program inside a package (example path shown):

```bash
# from repository root
cd StudentGradeCalculation/src
javac -d ../../out com/mile1/main/StudentMain.java
java -cp ../../out com.mile1.main.StudentMain
```

Example 3 — build and test the Maven subproject `JunitLearning`:

```bash
cd JunitLearning
mvn test
mvn package
```

Add or adapt commands above depending on the file you want to run. If a class belongs to a package, compile with `-d` to place .class files in an output tree and run using the package-qualified class name.

## Screenshots

Add screenshots to help readers quickly understand project output or GUI demos.

Recommended location in the repo:

- docs/screenshots/

To add a screenshot called `example.png`:

1. Create the folder: `mkdir -p docs/screenshots`
2. Copy the image to `docs/screenshots/example.png`
3. Reference it from this README:

```markdown
![Example output](docs/screenshots/example.png)
```

(If you're on Windows PowerShell, replace `mkdir -p` with `New-Item -ItemType Directory -Force -Path docs\screenshots`.)

Sample placeholder (remove once you add your real screenshots):

![Screenshot placeholder](https://via.placeholder.com/600x200.png?text=Add+your+screenshot+in+docs%2Fscreenshots)

## Recommended .gitignore & cleanup

This repository currently contains source files and some compiled artifacts may have been committed. Recommended steps:

1. Add a Java/Maven .gitignore (example below).
2. Remove committed build artifacts (`*.class`, `target/`, `out/`, `.classpath`, `.project`, `.idea/`, etc.).

Example .gitignore snippet to add to the repo root:

```
# Compiled class files
*.class
# Maven
target/
# IntelliJ
.idea/
*.iml
# VS Code
.vscode/
# Eclipse
.classpath
.project
.settings/
# Output folders
out/
```

To remove already-committed class files without deleting them locally:

```bash
git rm --cached -r -- "*.class"
git commit -m "Remove compiled class files and add .gitignore" -m "Co-authored-by: Copilot <223556219+Copilot@users.noreply.github.com>"
```

## Contribution

Contributions, issues, and suggestions are welcome. Typical ways to contribute:

- Open an issue describing a bug or improvement
- Send a pull request with documentation, fixes, or improvements
- Add README screenshots or short how-to guides for individual folders

## License

This repository is provided as-is for learning and demonstration purposes. Add an explicit LICENSE file (MIT, Apache-2.0, etc.) if you intend to redistribute or open-source.

---

_Updated README with badges, examples, and screenshot instructions._