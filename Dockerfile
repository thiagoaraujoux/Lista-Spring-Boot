# Imagem base com Java 21
FROM openjdk:21-jdk-slim

# Diretório de trabalho no container
WORKDIR /app

# Copia os arquivos do projeto
COPY . .

# Dá permissão de execução para o Gradle Wrapper
RUN chmod +x ./gradlew

# Executa o build do projeto com Gradle
RUN ./gradlew bootJar

# Expõe a porta 8080
EXPOSE 8080

# Comando para rodar a aplicação
CMD ["java", "-jar", "build/libs/app.jar"]
