# IO
Considered charsets, package java.io, serialization and working with file system
## Tasks
### Delete zero
`src/_5_labs/_2_stream/_1_delete_zero/DeleteZeroLab`  
Using finite state machine, write a program that removes all zeros from specified InputSteam. If there are several zeros in a row, program should delete them for once
### Entity input output stream
`src/_5_labs/_2_stream/_2_entity_is_os`  
Write a program that implements adapter from EntityOutputStream to OutputStream and from EntityInputStream to InputStream for specified entity  
`src/_5_labs/_2_stream/_3_entity_reader_writer`  
Write a program that implements adapter from EntityWriter to Writer and from EntityReader to Reader for specified entity
### Byte array output stream
`src/_5_labs/_2_stream/_4_strategy`  
Write a program that implements ByteArrayOutputStream. Creation of additional buffer takes place using specified strategy. This implementation must have methods for writing one byte and byte array. When writing large byte array, choose optimal strategy for allocating new buffers.
### File system

Write a program that
- `src/_5_labs/_3_file_system/_1_random_access`  
`Record` - class that contains two fields: an 'id' of type int and 'data' of type byte[]. The 'date' field is from 0 to 64 bytes. Null is not valid.  
`RecordStorage` - class that "does" from RandomAccessFile - "Record storage" with random access:  
`Application` - class that demonstrates usage of this storage.  
In this case `RecordStorage` allows you to store records of the same size - 64 bytes.  
**Task:** to make the RecordsStore able to store records of arbitrary size up to 64 bytes.
- `src/_5_labs/_3_file_system/_2_look_for_new_big_image`  
Finds files and directories with specified parameters
- `src/_5_labs/_3_file_system/_3_copy_dir`  
Copies content of one directory to another
