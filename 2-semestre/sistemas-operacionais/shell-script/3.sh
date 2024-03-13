#!/bin/bash

if [ -x 3_exemplo.sh ]; then
  echo "3_exemplo é executável"
else
  echo "3_exemplo não é executável"
  chmod +x 3_exemplo.sh
fi
