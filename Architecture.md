# Programming Environment #

This project uses Java as it's base programming language. It was created using Netbeans, but future versions will be ported to use Maven as it's project manager and build system.

## Dependencies ##

The project needs the following libraries to compile and run:

  * commons-lang-2.4
  * antlr-3.2 (only the runtime)
  * xstream-1.3 (including the xpp3)
  * log4j-1.2.15
  * javassit
  * scannotation

# User Interface #

The application uses Swing to build the user interface. It's not possible, yet, to rename the files and get the results all over the command line, but the parameters passed will reflect the initial state of the GUI. If no parameters are passed, the application will start with all the fields blank.

# Custom Language #

This project used ANTLR (Another Tool for Language Recognition) for implementing it's own replace expression language, which starting from version 2 is a subset of XML language.

The idea is to be simple (though not very neat - lot's of symbols) and easy to learn (since many people already know XML). The ReplaceEL needed to accept multiple hierarchies on it's structure, so that the functions can operate on it's children's result. So XML was the best option available.

For more details considering this language, follow this link [ReplaceEL](ReplaceEL.md)

# Extensions #

Regex-renamer was built to be extendable in its variable expressions. It has a lot of built-in variable expressions but a developer can create more. To do that, the API has to be used.

In this first version the extensions won't be allowed yet, because i'm still developing the component architecture.