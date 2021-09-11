#Java sources dir
SOURCEDIR = src
#output directory
OUTDIR = out
#class directory
CLASSDIR = classes

#main class package
MAINPACKAGE = metroscript
#main class name
MAINCLASS = Main
#main function arguments
ARGS = 
#redirect terminal output to this file
OUT_FILE = out.txt



#					DO NOT CHANGE
MAINFILE = $(SOURCEDIR)/$(subst .,/,$(MAINPACKAGE))/$(MAINCLASS).java
COMP = javac
JVM = java
out = > $(OUT_FILE)
FILES := $(shell find . -name '*.java')
COMPILED_FILES := $(subst .java,.class, $(subst ./src,./$(OUTDIR),$(FILES)))
#					DO NOT CHANGE

PHONY: default compile clean run runToFile


compile: $(COMPILED_FILES)

$(OUTDIR)/%.class: $(SOURCEDIR)/%.java | $(OUTDIR)
	$(COMP) -d $(OUTDIR) -classpath $(CLASSDIR) -sourcepath $(SOURCEDIR) $<

$(OUTDIR):
	mkdir -p $@

clean:
ifndef OUTDIR
	$(error Empty output path.)
endif
	rm -rf ./$(OUTDIR)/*
	rm -f $(OUT_FILE)

run: compile
	$(JVM) -cp ./$(OUTDIR) $(MAINPACKAGE).$(MAINCLASS) $(ARGS)

runToFile: compile 
	$(JVM) -cp ./$(OUTDIR) $(MAINPACKAGE).$(MAINCLASS) $(ARGS) $(out)
