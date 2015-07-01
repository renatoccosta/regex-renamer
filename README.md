# regex-renamer
Regex Renamer is a batch file renamer that accecpts regular expressions to locate and substitute file names under a directory (or subdirectories).

The substitution values can be "hard typed" values or it can come from the file metadata (like modified date and size) or even from the file's content when it's a known type (like JPG, MP3, MP4).

What's special about Regex Renamer is that it has a pluggable architecture that allows developers to create very simple plugins to read information from new file types and use that information as replacement parameters.
