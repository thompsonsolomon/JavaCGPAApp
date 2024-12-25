FROM openjdk:17-jdk-slim
WORKDIR /app
COPY CGPACalculator.java .
RUN javac CGPACalculator.java
CMD ["java", "CGPACalculator"]