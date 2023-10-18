# Distributed under the OSI-approved BSD 3-Clause License.  See accompanying
# file Copyright.txt or https://cmake.org/licensing for details.

cmake_minimum_required(VERSION 3.5)

file(MAKE_DIRECTORY
  "/Users/keita-katsumi/dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-src"
  "/Users/keita-katsumi/dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-build"
  "/Users/keita-katsumi/Dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-subbuild/googletest-populate-prefix"
  "/Users/keita-katsumi/Dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-subbuild/googletest-populate-prefix/tmp"
  "/Users/keita-katsumi/Dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-subbuild/googletest-populate-prefix/src/googletest-populate-stamp"
  "/Users/keita-katsumi/Dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-subbuild/googletest-populate-prefix/src"
  "/Users/keita-katsumi/Dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-subbuild/googletest-populate-prefix/src/googletest-populate-stamp"
)

set(configSubDirs )
foreach(subDir IN LISTS configSubDirs)
    file(MAKE_DIRECTORY "/Users/keita-katsumi/Dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-subbuild/googletest-populate-prefix/src/googletest-populate-stamp/${subDir}")
endforeach()
if(cfgdir)
  file(MAKE_DIRECTORY "/Users/keita-katsumi/Dropbox/Programing/GitHub/kkatsumiPCC/C-Plus-Plus/2D_Pointer_lab_and_plane/build/_deps/googletest-subbuild/googletest-populate-prefix/src/googletest-populate-stamp${cfgdir}") # cfgdir has leading slash
endif()
