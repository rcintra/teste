Procedimentos executados para criar o projeto

mvn archetype:generate -B -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=webapp-javaee6

Criar um projeto 
mvn archetype:generate -B -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=pom-root -DgroupId=br.ccb.com -DartifactId=teste -Dpackage=br.ccb.com

cd $projeto_name

Criar modulo EAR
mvn archetype:generate -B -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=ear-javaee6 -DgroupId=br.ccb.com -DartifactId=teste-ear -Dpackage=br.ccb.com

Criar modulo WEB
mvn archetype:generate -B -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=webapp-javaee6 -DgroupId=br.ccb.com -DartifactId=teste-web -Dpackage=br.ccb.com

Criar modulo EJB
mvn archetype:generate -B -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=ejb-javaee6 -DgroupId=br.ccb.com -DartifactId=teste-ejb -Dpackage=br.ccb.com

Criar modulo Util
mvn archetype:generate -B -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DgroupId=br.ccb.com -DartifactId=teste-util -Dpackage=br.ccb.com

Criar modulo Core
mvn archetype:generate -B -DarchetypeGroupId=org.codehaus.mojo.archetypes -DarchetypeArtifactId=ejb-javaee6 -DgroupId=br.ccb.com -DartifactId=teste-core -Dpackage=br.ccb.com

mvn clean install
mvn eclipse:eclipse

open eclipse
import project

Retirar group e version dos modulos

incluir as dependencias no modulo EAR (WEB, EJB, UTIL)
converter o modulo persistence para usar facets - add suporte para JPA
