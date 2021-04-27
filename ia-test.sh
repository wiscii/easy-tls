#!/bin/sh

./ia-build-server-tlskey-s01.exp
./ia-inline-server-tlskey-s01.exp

./ia-build-client-tlskey-c01.exp
./ia-inline-client-tlskey-c01.exp

./ia-build-client-tlskey-c01-bob.exp
./ia-inline-client-tlskey-c01-bob.exp

./ia-remove-server-inline-s01.exp
./ia-remove-server-tlskey-s01.exp

./ia-remove-client-inline-c01.exp
./ia-remove-client-tlskey-c01.exp

./ia-remove-client-inline-c01-bob.exp
./ia-remove-client-tlskey-c01-bob.exp
