#Root del (sub)directorio con los archivos .java
SOURCEDIR = src
#Directorio de salida
OUTDIR = out
#Directorio con las clases (si es que se usa)
CLASSDIR = classes

#Package que contiene a la clase Main
MAINPACKAGE = metroscript
#Nombre de la clase de ejecución
MAINCLASS = Main
#Argumentos para la función main
ARGS = 
#Salida de programa
OUT_FILE = out.txt


#					NO CAMBIAR
MAINFILE = $(SOURCEDIR)/$(subst .,/,$(MAINPACKAGE))/$(MAINCLASS).java
COMP = javac
JVM = java
out = > $(OUT_FILE)
#					NO CAMBIAR

PHONY: default compile clean run runToFile

default: compile

compile:
	$(COMP) -d $(OUTDIR) -classpath $(CLASSDIR) -sourcepath $(SOURCEDIR) $(MAINFILE)

clean:
ifndef OUTDIR
	$(error Path de salida vacío)
endif
	rm -rf ./$(OUTDIR)/*
	rm -f $(OUT_FILE)

run: compile
	$(JVM) -cp ./$(OUTDIR) $(MAINPACKAGE).$(MAINCLASS) $(ARGS)

runToFile: compile 
	$(JVM) -cp ./$(OUTDIR) $(MAINPACKAGE).$(MAINCLASS) $(ARGS) $(out)
