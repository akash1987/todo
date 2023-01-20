import Dependencies._

ThisBuild / scalaVersion := "2.13.8"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "com.example"
ThisBuild / organizationName := "todo"

val zio        = "2.0.4"
val zioHttp    = "0.0.3"
val zioLogging = "2.1.5"
val jwt        = "9.1.2"
val slick      = "3.4.1"
val totoshi    = "2.6.0"
val jsoniter   = "2.17.9"
val mariadb    = "3.1.0"
val jodatime   = "2.12.0"

lazy val root = (project in file("."))
  .settings(
    name := "Todo",
    libraryDependencies += scalaTest % Test,
    libraryDependencies ++= Seq(
      "dev.zio"                               %% "zio"                   % zio,
      "dev.zio"                               %% "zio-http"              % zioHttp,
      "com.github.jwt-scala"                  %% "jwt-core"              % jwt,
      "com.typesafe.slick"                    %% "slick"                 % slick,
      "com.typesafe.slick"                    %% "slick-hikaricp"        % slick,
      "com.github.tototoshi"                  %% "slick-joda-mapper"     % totoshi,
      "joda-time"                             % "joda-time"              % jodatime,
      "org.mariadb.jdbc"                      % "mariadb-java-client"    % mariadb,
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % jsoniter,
      "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniter % "provided",
      "dev.zio"                               %% "zio-test"              % zio % Test,
      "dev.zio"                               %% "zio-test-sbt"          % zio % Test
    )
  )

// See https://www.scala-sbt.org/1.x/docs/Using-Sonatype.html for instructions on how to publish to Sonatype.
