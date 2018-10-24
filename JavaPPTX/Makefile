# Makefile for JavaPPTX
# Last modified on Mon Jun  4 18:15:33 2018 by eroberts
#****************************************************************

TOOLS = \
    pprun

JARFILE = pptx.jar
JARDIR = $(HOME)/java/jar
EXPORTDIR = $(HOME)/bin

JAVAC = javac -sourcepath src \
              -d classes \
              -Xlint:-serial -Xlint:deprecation

DOCPACKAGES = \
    edu.stanford.cs.pptx \
    edu.stanford.cs.pptx.code \
    edu.stanford.cs.pptx.chart

CLASSES = \
    classes/edu/stanford/cs/csslib/CSSColor.class \
    classes/edu/stanford/cs/csslib/CSSFont.class \
    classes/edu/stanford/cs/pptx/PPArc.class \
    classes/edu/stanford/cs/pptx/PPAutoShape.class \
    classes/edu/stanford/cs/pptx/PPDumpShapeJS.class \
    classes/edu/stanford/cs/pptx/PPFreeform.class \
    classes/edu/stanford/cs/pptx/PPGroup.class \
    classes/edu/stanford/cs/pptx/PPLine.class \
    classes/edu/stanford/cs/pptx/PPOval.class \
    classes/edu/stanford/cs/pptx/PPOvalCallout.class \
    classes/edu/stanford/cs/pptx/PPPath.class \
    classes/edu/stanford/cs/pptx/PPPicture.class \
    classes/edu/stanford/cs/pptx/PPPie.class \
    classes/edu/stanford/cs/pptx/PPPointer.class \
    classes/edu/stanford/cs/pptx/PPPolygon.class \
    classes/edu/stanford/cs/pptx/PPRect.class \
    classes/edu/stanford/cs/pptx/PPRectCallout.class \
    classes/edu/stanford/cs/pptx/PPSaveJS.class \
    classes/edu/stanford/cs/pptx/PPSavePPTX.class \
    classes/edu/stanford/cs/pptx/PPShape.class \
    classes/edu/stanford/cs/pptx/PPShapeFactory.class \
    classes/edu/stanford/cs/pptx/PPShapeOptionParser.class \
    classes/edu/stanford/cs/pptx/PPShow.class \
    classes/edu/stanford/cs/pptx/PPSimpleShape.class \
    classes/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.class \
    classes/edu/stanford/cs/pptx/PPSlide.class \
    classes/edu/stanford/cs/pptx/PPStar.class \
    classes/edu/stanford/cs/pptx/PPTextBox.class \
    classes/edu/stanford/cs/pptx/PPTextShape.class \
    classes/edu/stanford/cs/pptx/PPTextShapeOptionParser.class \
    classes/edu/stanford/cs/pptx/PPTitle.class \
    classes/edu/stanford/cs/pptx/animation/PPShapeAnimator.class \
    classes/edu/stanford/cs/pptx/chart/PPChart.class \
    classes/edu/stanford/cs/pptx/chart/PPLineChart.class \
    classes/edu/stanford/cs/pptx/chart/PPPieChart.class \
    classes/edu/stanford/cs/pptx/code/PPArray.class \
    classes/edu/stanford/cs/pptx/code/PPCodeDisplaySlide.class \
    classes/edu/stanford/cs/pptx/code/PPCodeImage.class \
    classes/edu/stanford/cs/pptx/code/PPCodeTraceSlide.class \
    classes/edu/stanford/cs/pptx/code/PPConsole.class \
    classes/edu/stanford/cs/pptx/code/PPFunction.class \
    classes/edu/stanford/cs/pptx/code/PPHeapStackViewer.class \
    classes/edu/stanford/cs/pptx/code/PPJSSyntaxColorer.class \
    classes/edu/stanford/cs/pptx/code/PPMonospacedLabel.class \
    classes/edu/stanford/cs/pptx/code/PPPythonSyntaxColorer.class \
    classes/edu/stanford/cs/pptx/code/PPStackFrame.class \
    classes/edu/stanford/cs/pptx/code/PPSyntaxColorer.class \
    classes/edu/stanford/cs/pptx/code/PPValueTag.class \
    classes/edu/stanford/cs/pptx/code/PPVar.class \
    classes/edu/stanford/cs/pptx/code/PPVariable.class \
    classes/edu/stanford/cs/pptx/code/PPWindowImage.class \
    classes/edu/stanford/cs/pptx/code/PPWord.class \
    classes/edu/stanford/cs/pptx/effect/AnimationEffect.class \
    classes/edu/stanford/cs/pptx/effect/AppearEffect.class \
    classes/edu/stanford/cs/pptx/effect/BezierMotionEffect.class \
    classes/edu/stanford/cs/pptx/effect/ChangeFillColorEffect.class \
    classes/edu/stanford/cs/pptx/effect/ChangeFontColorEffect.class \
    classes/edu/stanford/cs/pptx/effect/ChangeLineColorEffect.class \
    classes/edu/stanford/cs/pptx/effect/CheckerboardInEffect.class \
    classes/edu/stanford/cs/pptx/effect/CheckerboardOutEffect.class \
    classes/edu/stanford/cs/pptx/effect/DisappearEffect.class \
    classes/edu/stanford/cs/pptx/effect/FadeInEffect.class \
    classes/edu/stanford/cs/pptx/effect/FadeOutEffect.class \
    classes/edu/stanford/cs/pptx/effect/FadedZoomInEffect.class \
    classes/edu/stanford/cs/pptx/effect/FadedZoomOutEffect.class \
    classes/edu/stanford/cs/pptx/effect/FlyInEffect.class \
    classes/edu/stanford/cs/pptx/effect/FlyOutEffect.class \
    classes/edu/stanford/cs/pptx/effect/GrowEffect.class \
    classes/edu/stanford/cs/pptx/effect/LinearMotionEffect.class \
    classes/edu/stanford/cs/pptx/effect/MotionPathState.class \
    classes/edu/stanford/cs/pptx/effect/NoTransition.class \
    classes/edu/stanford/cs/pptx/effect/RotateEffect.class \
    classes/edu/stanford/cs/pptx/effect/ShrinkEffect.class \
    classes/edu/stanford/cs/pptx/effect/SlideTransition.class \
    classes/edu/stanford/cs/pptx/effect/SpinEffect.class \
    classes/edu/stanford/cs/pptx/effect/WipeInEffect.class \
    classes/edu/stanford/cs/pptx/effect/WipeOutEffect.class \
    classes/edu/stanford/cs/pptx/effect/ZoomInEffect.class \
    classes/edu/stanford/cs/pptx/effect/ZoomOutEffect.class \
    classes/edu/stanford/cs/pptx/javadoc/PPDocumentEffects.class \
    classes/edu/stanford/cs/pptx/util/HexByteInputStream.class \
    classes/edu/stanford/cs/pptx/util/OptionParser.class \
    classes/edu/stanford/cs/pptx/util/PPOutputStream.class \
    classes/edu/stanford/cs/pptx/util/PPUtil.class


# ***************************************************************
# Entry to bring the package up to date
#    The "make all" entry should be the first real entry

all: $(CLASSES) jar

jar: lib/$(JARFILE)

$(JARFILE): jar

javadoc:
	@find classes -name 'package.html' -exec rm '{}' ';'
	javadoc -d doc -sourcepath src \
                       -noqualifier 'java.*:javax.*' \
                       -windowtitle "JavaPPTX" \
                       -doctitle "The JavaPPTX Package" \
                       -classpath classes \
                       -public $(DOCPACKAGES)
	java -cp classes edu.stanford.cs.pptx.javadoc.PPDocumentEffects

export: all
	@-(for x in $(TOOLS) ; do \
             echo link `pwd`/bin/$$x $(EXPORTDIR) ; \
             rm -f $(EXPORTDIR)/$$x ; \
             ln -s `pwd`/bin/$$x $(EXPORTDIR) ; \
           done)
	@echo link `pwd`/lib/$(JARFILE) $(JARDIR)
	@rm -f $(JARDIR)/$(JARFILE)
	@ln -s `pwd`/lib/$(JARFILE) $(JARDIR)

# ***************************************************************
# Standard entries to remove files from the directories
#    tidy    -- eliminate unwanted files
#    scratch -- delete derived files in preparation for rebuild

tidy:
	@rm -f `find . -name "*~" -o -name core -o -name "*.tmp"`

scratch clean: tidy
	@rm -fr classes
	@mkdir classes
	@echo "[clean succeeded]"

# ***************************************************************
# Create the JAR file

lib/$(JARFILE): $(CLASSES)
	@rm -f `find classes -name package.html -o -name '*~'`
	@(cd classes ; \
          jar cfv ../lib/$(JARFILE) `find . -type f | sed 's|^[.]/||'` ; \
         )

# ***************************************************************
# Compilations for the Java classes

classes/edu/stanford/cs/csslib/CSSColor.class: \
          src/edu/stanford/cs/csslib/CSSColor.java
	@echo javac src/edu/stanford/cs/csslib/CSSColor.java
	@$(JAVAC) src/edu/stanford/cs/csslib/CSSColor.java

classes/edu/stanford/cs/csslib/CSSFont.class: \
          src/edu/stanford/cs/csslib/CSSFont.java
	@echo javac src/edu/stanford/cs/csslib/CSSFont.java
	@$(JAVAC) src/edu/stanford/cs/csslib/CSSFont.java

classes/edu/stanford/cs/pptx/PPArc.class: \
          src/edu/stanford/cs/pptx/PPArc.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
	      src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPArc.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPArc.java

classes/edu/stanford/cs/pptx/PPAutoShape.class: \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
	      src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPAutoShape.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPAutoShape.java

classes/edu/stanford/cs/pptx/PPFreeform.class: \
          src/edu/stanford/cs/pptx/PPFreeform.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPath.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
	      src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPFreeform.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPFreeform.java

classes/edu/stanford/cs/pptx/PPGroup.class: \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPGroup.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPGroup.java

classes/edu/stanford/cs/pptx/PPLine.class: \
          src/edu/stanford/cs/pptx/PPLine.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPLine.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPLine.java

classes/edu/stanford/cs/pptx/PPOval.class: \
          src/edu/stanford/cs/pptx/PPOval.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPOval.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPOval.java

classes/edu/stanford/cs/pptx/PPOvalCallout.class: \
          src/edu/stanford/cs/pptx/PPOvalCallout.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPOvalCallout.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPOvalCallout.java

classes/edu/stanford/cs/pptx/PPPath.class: \
          src/edu/stanford/cs/pptx/PPPath.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPPath.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPPath.java

classes/edu/stanford/cs/pptx/PPPicture.class: \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPPicture.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPPicture.java

classes/edu/stanford/cs/pptx/PPPie.class: \
          src/edu/stanford/cs/pptx/PPPie.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPPie.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPPie.java

classes/edu/stanford/cs/pptx/PPPointer.class: \
          src/edu/stanford/cs/pptx/PPPointer.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPFreeform.java \
          src/edu/stanford/cs/pptx/PPPath.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPPointer.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPPointer.java

classes/edu/stanford/cs/pptx/PPPolygon.class: \
          src/edu/stanford/cs/pptx/PPPolygon.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPath.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPPolygon.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPPolygon.java

classes/edu/stanford/cs/pptx/PPRect.class: \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPRect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPRect.java

classes/edu/stanford/cs/pptx/PPRectCallout.class: \
          src/edu/stanford/cs/pptx/PPRectCallout.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPRectCallout.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPRectCallout.java

classes/edu/stanford/cs/pptx/PPSavePPTX.class: \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPSavePPTX.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPSavePPTX.java

classes/edu/stanford/cs/pptx/PPShape.class: \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPShape.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPShape.java

classes/edu/stanford/cs/pptx/PPShapeFactory.class: \
          src/edu/stanford/cs/pptx/PPShapeFactory.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPShapeFactory.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPShapeFactory.java

classes/edu/stanford/cs/pptx/PPShapeOptionParser.class: \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPShapeOptionParser.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPShapeOptionParser.java

classes/edu/stanford/cs/pptx/PPShow.class: \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPShow.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPShow.java

classes/edu/stanford/cs/pptx/PPSimpleShape.class: \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPSimpleShape.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPSimpleShape.java

classes/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.class: \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java

classes/edu/stanford/cs/pptx/PPSlide.class: \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPSlide.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPSlide.java

classes/edu/stanford/cs/pptx/PPStar.class: \
          src/edu/stanford/cs/pptx/PPStar.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPStar.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPStar.java

classes/edu/stanford/cs/pptx/PPTextBox.class: \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPTextBox.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPTextBox.java

classes/edu/stanford/cs/pptx/PPTextShape.class: \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPTextShape.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPTextShape.java

classes/edu/stanford/cs/pptx/PPTextShapeOptionParser.class: \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java

classes/edu/stanford/cs/pptx/PPTitle.class: \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/PPTitle.java
	@$(JAVAC) src/edu/stanford/cs/pptx/PPTitle.java

classes/edu/stanford/cs/pptx/animation/PPShapeAnimator.class: \
          src/edu/stanford/cs/pptx/animation/PPShapeAnimator.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/animation/PPShapeAnimator.java
	@$(JAVAC) src/edu/stanford/cs/pptx/animation/PPShapeAnimator.java

classes/edu/stanford/cs/pptx/chart/PPChart.class: \
          src/edu/stanford/cs/pptx/chart/PPChart.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPLine.java \
          src/edu/stanford/cs/pptx/PPOval.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeFactory.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/chart/PPChart.java
	@$(JAVAC) src/edu/stanford/cs/pptx/chart/PPChart.java

classes/edu/stanford/cs/pptx/chart/PPLineChart.class: \
          src/edu/stanford/cs/pptx/chart/PPLineChart.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPFreeform.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPLine.java \
          src/edu/stanford/cs/pptx/PPOval.java \
          src/edu/stanford/cs/pptx/PPPath.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeFactory.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/chart/PPChart.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/chart/PPLineChart.java
	@$(JAVAC) src/edu/stanford/cs/pptx/chart/PPLineChart.java

classes/edu/stanford/cs/pptx/chart/PPPieChart.class: \
          src/edu/stanford/cs/pptx/chart/PPPieChart.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPLine.java \
          src/edu/stanford/cs/pptx/PPOval.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPPie.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeFactory.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/chart/PPChart.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/chart/PPPieChart.java
	@$(JAVAC) src/edu/stanford/cs/pptx/chart/PPPieChart.java

classes/edu/stanford/cs/pptx/code/PPArray.class: \
          src/edu/stanford/cs/pptx/code/PPArray.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPLine.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPArray.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPArray.java

classes/edu/stanford/cs/pptx/code/PPCodeDisplaySlide.class: \
          src/edu/stanford/cs/pptx/code/PPCodeDisplaySlide.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPCodeDisplaySlide.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPCodeDisplaySlide.java

classes/edu/stanford/cs/pptx/code/PPCodeImage.class: \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPCodeImage.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPCodeImage.java

classes/edu/stanford/cs/pptx/code/PPCodeTraceSlide.class: \
          src/edu/stanford/cs/pptx/code/PPCodeTraceSlide.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/pptx/code/PPConsole.java \
          src/edu/stanford/cs/pptx/code/PPFunction.java \
          src/edu/stanford/cs/pptx/code/PPHeapStackViewer.java \
          src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java \
          src/edu/stanford/cs/pptx/code/PPStackFrame.java \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/pptx/code/PPVariable.java \
          src/edu/stanford/cs/pptx/code/PPWindowImage.java \
          src/edu/stanford/cs/pptx/code/PPWord.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPCodeTraceSlide.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPCodeTraceSlide.java

classes/edu/stanford/cs/pptx/code/PPConsole.class: \
          src/edu/stanford/cs/pptx/code/PPConsole.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPWindowImage.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPConsole.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPConsole.java

classes/edu/stanford/cs/pptx/code/PPFunction.class: \
          src/edu/stanford/cs/pptx/code/PPFunction.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/pptx/code/PPCodeTraceSlide.java \
          src/edu/stanford/cs/pptx/code/PPConsole.java \
          src/edu/stanford/cs/pptx/code/PPHeapStackViewer.java \
          src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java \
          src/edu/stanford/cs/pptx/code/PPStackFrame.java \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/pptx/code/PPVariable.java \
          src/edu/stanford/cs/pptx/code/PPWindowImage.java \
          src/edu/stanford/cs/pptx/code/PPWord.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPFunction.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPFunction.java

classes/edu/stanford/cs/pptx/code/PPHeapStackViewer.class: \
          src/edu/stanford/cs/pptx/code/PPHeapStackViewer.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/pptx/code/PPCodeTraceSlide.java \
          src/edu/stanford/cs/pptx/code/PPConsole.java \
          src/edu/stanford/cs/pptx/code/PPFunction.java \
          src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java \
          src/edu/stanford/cs/pptx/code/PPStackFrame.java \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/pptx/code/PPVariable.java \
          src/edu/stanford/cs/pptx/code/PPWindowImage.java \
          src/edu/stanford/cs/pptx/code/PPWord.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPHeapStackViewer.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPHeapStackViewer.java

classes/edu/stanford/cs/pptx/code/PPJSSyntaxColorer.class: \
          src/edu/stanford/cs/pptx/code/PPJSSyntaxColorer.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPJSSyntaxColorer.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPJSSyntaxColorer.java

classes/edu/stanford/cs/pptx/code/PPMonospacedLabel.class: \
          src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java

classes/edu/stanford/cs/pptx/code/PPPythonSyntaxColorer.class: \
          src/edu/stanford/cs/pptx/code/PPPythonSyntaxColorer.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPPythonSyntaxColorer.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPPythonSyntaxColorer.java

classes/edu/stanford/cs/pptx/code/PPStackFrame.class: \
          src/edu/stanford/cs/pptx/code/PPStackFrame.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/pptx/code/PPCodeTraceSlide.java \
          src/edu/stanford/cs/pptx/code/PPConsole.java \
          src/edu/stanford/cs/pptx/code/PPFunction.java \
          src/edu/stanford/cs/pptx/code/PPHeapStackViewer.java \
          src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/pptx/code/PPVariable.java \
          src/edu/stanford/cs/pptx/code/PPWindowImage.java \
          src/edu/stanford/cs/pptx/code/PPWord.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPStackFrame.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPStackFrame.java

classes/edu/stanford/cs/pptx/code/PPSyntaxColorer.class: \
          src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPCodeImage.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPSyntaxColorer.java

classes/edu/stanford/cs/pptx/code/PPValueTag.class: \
          src/edu/stanford/cs/pptx/code/PPValueTag.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPLine.java \
          src/edu/stanford/cs/pptx/PPOvalCallout.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPValueTag.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPValueTag.java

classes/edu/stanford/cs/pptx/code/PPVar.class: \
          src/edu/stanford/cs/pptx/code/PPVar.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java \
          src/edu/stanford/cs/pptx/code/PPVariable.java \
          src/edu/stanford/cs/pptx/code/PPWord.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPVar.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPVar.java

classes/edu/stanford/cs/pptx/code/PPVariable.class: \
          src/edu/stanford/cs/pptx/code/PPVariable.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java \
          src/edu/stanford/cs/pptx/code/PPWord.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPVariable.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPVariable.java

classes/edu/stanford/cs/pptx/code/PPWindowImage.class: \
          src/edu/stanford/cs/pptx/code/PPWindowImage.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPWindowImage.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPWindowImage.java

classes/edu/stanford/cs/pptx/code/PPWord.class: \
          src/edu/stanford/cs/pptx/code/PPWord.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPAutoShape.java \
          src/edu/stanford/cs/pptx/PPGroup.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPRect.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextBox.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/code/PPMonospacedLabel.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/code/PPWord.java
	@$(JAVAC) src/edu/stanford/cs/pptx/code/PPWord.java

classes/edu/stanford/cs/pptx/effect/AnimationEffect.class: \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/AnimationEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/AnimationEffect.java

classes/edu/stanford/cs/pptx/effect/AppearEffect.class: \
          src/edu/stanford/cs/pptx/effect/AppearEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/AppearEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/AppearEffect.java

classes/edu/stanford/cs/pptx/effect/BezierMotionEffect.class: \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java

classes/edu/stanford/cs/pptx/effect/ChangeFillColorEffect.class: \
          src/edu/stanford/cs/pptx/effect/ChangeFillColorEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/ChangeFillColorEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/ChangeFillColorEffect.java

classes/edu/stanford/cs/pptx/effect/ChangeFontColorEffect.class: \
          src/edu/stanford/cs/pptx/effect/ChangeFontColorEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/ChangeFontColorEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/ChangeFontColorEffect.java

classes/edu/stanford/cs/pptx/effect/ChangeLineColorEffect.class: \
          src/edu/stanford/cs/pptx/effect/ChangeLineColorEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/ChangeLineColorEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/ChangeLineColorEffect.java

classes/edu/stanford/cs/pptx/effect/CheckerboardInEffect.class: \
          src/edu/stanford/cs/pptx/effect/CheckerboardInEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/CheckerboardInEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/CheckerboardInEffect.java

classes/edu/stanford/cs/pptx/effect/CheckerboardOutEffect.class: \
          src/edu/stanford/cs/pptx/effect/CheckerboardOutEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/CheckerboardOutEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/CheckerboardOutEffect.java

classes/edu/stanford/cs/pptx/effect/DisappearEffect.class: \
          src/edu/stanford/cs/pptx/effect/DisappearEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/DisappearEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/DisappearEffect.java

classes/edu/stanford/cs/pptx/effect/FadeInEffect.class: \
          src/edu/stanford/cs/pptx/effect/FadeInEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/FadeInEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/FadeInEffect.java

classes/edu/stanford/cs/pptx/effect/FadeOutEffect.class: \
          src/edu/stanford/cs/pptx/effect/FadeOutEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/FadeOutEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/FadeOutEffect.java

classes/edu/stanford/cs/pptx/effect/FadedZoomInEffect.class: \
          src/edu/stanford/cs/pptx/effect/FadedZoomInEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/FadedZoomInEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/FadedZoomInEffect.java

classes/edu/stanford/cs/pptx/effect/FadedZoomOutEffect.class: \
          src/edu/stanford/cs/pptx/effect/FadedZoomOutEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/FadedZoomOutEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/FadedZoomOutEffect.java

classes/edu/stanford/cs/pptx/effect/FlyInEffect.class: \
          src/edu/stanford/cs/pptx/effect/FlyInEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/FlyInEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/FlyInEffect.java

classes/edu/stanford/cs/pptx/effect/FlyOutEffect.class: \
          src/edu/stanford/cs/pptx/effect/FlyOutEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/FlyOutEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/FlyOutEffect.java

classes/edu/stanford/cs/pptx/effect/GrowEffect.class: \
          src/edu/stanford/cs/pptx/effect/GrowEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/GrowEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/GrowEffect.java

classes/edu/stanford/cs/pptx/effect/LinearMotionEffect.class: \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java

classes/edu/stanford/cs/pptx/effect/MotionPathState.class: \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java
	@echo javac src/edu/stanford/cs/pptx/effect/MotionPathState.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/MotionPathState.java

classes/edu/stanford/cs/pptx/effect/NoTransition.class: \
          src/edu/stanford/cs/pptx/effect/NoTransition.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/NoTransition.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/NoTransition.java

classes/edu/stanford/cs/pptx/effect/RotateEffect.class: \
          src/edu/stanford/cs/pptx/effect/RotateEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/RotateEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/RotateEffect.java

classes/edu/stanford/cs/pptx/effect/ShrinkEffect.class: \
          src/edu/stanford/cs/pptx/effect/ShrinkEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/GrowEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/ShrinkEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/ShrinkEffect.java

classes/edu/stanford/cs/pptx/effect/SlideTransition.class: \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/SlideTransition.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/SlideTransition.java

classes/edu/stanford/cs/pptx/effect/SpinEffect.class: \
          src/edu/stanford/cs/pptx/effect/SpinEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/SpinEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/SpinEffect.java

classes/edu/stanford/cs/pptx/effect/WipeInEffect.class: \
          src/edu/stanford/cs/pptx/effect/WipeInEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/WipeInEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/WipeInEffect.java

classes/edu/stanford/cs/pptx/effect/WipeOutEffect.class: \
          src/edu/stanford/cs/pptx/effect/WipeOutEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/WipeOutEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/WipeOutEffect.java

classes/edu/stanford/cs/pptx/effect/ZoomInEffect.class: \
          src/edu/stanford/cs/pptx/effect/ZoomInEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/ZoomInEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/ZoomInEffect.java

classes/edu/stanford/cs/pptx/effect/ZoomOutEffect.class: \
          src/edu/stanford/cs/pptx/effect/ZoomOutEffect.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/PPPicture.java \
          src/edu/stanford/cs/pptx/PPSavePPTX.java \
          src/edu/stanford/cs/pptx/PPSaveJS.java \
          src/edu/stanford/cs/pptx/PPDumpShapeJS.java \
          src/edu/stanford/cs/pptx/PPShape.java \
          src/edu/stanford/cs/pptx/PPShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPShow.java \
          src/edu/stanford/cs/pptx/PPSimpleShape.java \
          src/edu/stanford/cs/pptx/PPSimpleShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPSlide.java \
          src/edu/stanford/cs/pptx/PPTextShape.java \
          src/edu/stanford/cs/pptx/PPTextShapeOptionParser.java \
          src/edu/stanford/cs/pptx/PPTitle.java \
          src/edu/stanford/cs/pptx/effect/AnimationEffect.java \
          src/edu/stanford/cs/pptx/effect/BezierMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/LinearMotionEffect.java \
          src/edu/stanford/cs/pptx/effect/MotionPathState.java \
          src/edu/stanford/cs/pptx/effect/SlideTransition.java \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java \
          src/edu/stanford/cs/pptx/util/OptionParser.java \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/effect/ZoomOutEffect.java
	@$(JAVAC) src/edu/stanford/cs/pptx/effect/ZoomOutEffect.java

classes/edu/stanford/cs/pptx/javadoc/PPDocumentEffects.class: \
          src/edu/stanford/cs/pptx/javadoc/PPDocumentEffects.java
	@echo javac src/edu/stanford/cs/pptx/javadoc/PPDocumentEffects.java
	@$(JAVAC) src/edu/stanford/cs/pptx/javadoc/PPDocumentEffects.java

classes/edu/stanford/cs/pptx/util/HexByteInputStream.class: \
          src/edu/stanford/cs/pptx/util/HexByteInputStream.java
	@echo javac src/edu/stanford/cs/pptx/util/HexByteInputStream.java
	@$(JAVAC) src/edu/stanford/cs/pptx/util/HexByteInputStream.java

classes/edu/stanford/cs/pptx/util/OptionParser.class: \
          src/edu/stanford/cs/pptx/util/OptionParser.java
	@echo javac src/edu/stanford/cs/pptx/util/OptionParser.java
	@$(JAVAC) src/edu/stanford/cs/pptx/util/OptionParser.java

classes/edu/stanford/cs/pptx/util/PPOutputStream.class: \
          src/edu/stanford/cs/pptx/util/PPOutputStream.java \
          src/edu/stanford/cs/csslib/CSSColor.java \
          src/edu/stanford/cs/pptx/util/PPUtil.java
	@echo javac src/edu/stanford/cs/pptx/util/PPOutputStream.java
	@$(JAVAC) src/edu/stanford/cs/pptx/util/PPOutputStream.java

classes/edu/stanford/cs/pptx/util/PPUtil.class: \
          src/edu/stanford/cs/pptx/util/PPUtil.java \
          src/edu/stanford/cs/csslib/CSSColor.java
	@echo javac src/edu/stanford/cs/pptx/util/PPUtil.java
	@$(JAVAC) src/edu/stanford/cs/pptx/util/PPUtil.java
